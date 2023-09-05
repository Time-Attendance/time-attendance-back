package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.settlement.*;
import com.douzone.timeattendance.mapper.SettlementMapper;
import com.douzone.timeattendance.mapper.TimeRecordMapper;
import com.douzone.timeattendance.mapper.WorkGroupRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SettlementService {

    private final SettlementMapper settlementMapper;
    private final WorkGroupRecordMapper workGroupRecordMapper;
    private final TimeRecordMapper timeRecordMapper;

    public void insert(Settlement settlement) {
        settlementMapper.insertSettlement(settlement);
    }

    @Transactional(readOnly = true)
    public List<SettlementResponse> findAll(SettlementFindRequest settlementFindRequest) {
        return settlementMapper.findAll(settlementFindRequest);
    }

    public void update(SettlementUpdateRequest settlementUpdateRequest) {
        settlementMapper.updateSettlement(settlementUpdateRequest);
    }

    //    @Scheduled(cron = "0 0 0 * * *")
    public void settlementSchedule() {

    }

    //근무, 유급, 무급인 회원들을 모아서 한번에 update, delete를 하는 메서드
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertSchedule() {

    }

    //회사와 근무그룹 ID 리스트
    public List<SettlementSearchDto> findCompanyIdAndWorkGroupIdList() {
        return settlementMapper.findCompanyIdAndWorkGroupIdList();

    }

    public SettlementUpdateDto unpaidCalculationProcess(SettlementFindCompanyDto settlementFindCompanyDto, String workStatus){

        LocalDateTime startTime = settlementFindCompanyDto.getStartWork();
        LocalDateTime endTime = settlementFindCompanyDto.getLeaveWork();
        Duration duration = Duration.between(startTime, endTime);

        SettlementUpdateDto settlementUpdateDto = SettlementUpdateDto.builder()
                .startTime(startTime.toLocalTime())
                .endTime(endTime.toLocalTime())
                .workingTime(LocalTime.of(0,0,0))
                .overTime(LocalTime.ofSecondOfDay(duration.getSeconds()))
                .dayType(workStatus)
                .dateUpdated(LocalDateTime.now())
                .build();
        return settlementUpdateDto;
    }

    //회원 list를 보고 회원들 한명씩 정산하는 메서드
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void settlementMembers(LocalDate date, List<SettlementFindCompanyDto> result) {
        List<SettlementUpdateDto> settlementUpdateWorks = new ArrayList<>();
        List<SettlementUpdateDto> settlementUpdateUnpaids = new ArrayList<>();
        List<Long> settlementIdsToDelete = new ArrayList<>();   // 무급일때, 삭제할 정산 id들을 모은 list

        for (SettlementFindCompanyDto settlementFindCompanyDto : result) {
            String workStatus = processWeekday(settlementFindCompanyDto, date); //해당 요일의 근무 상태
            if (settlementFindCompanyDto.getDate() == null) { //결근일때 -> 무급이나 유급일땐 그냥 통과
                if (workStatus.equals("근무")) { //결근
                    TimeRecord timeRecord = TimeRecord.builder()
                            .userId(settlementFindCompanyDto.getUserId())
                            .date(date)
                            .workState("근태이상")
                            .build();
                    timeRecordMapper.insert(timeRecord);    //결근일때, 출퇴근 기록 insert

                    //해당 회원의 최근의 workGroupRecord을 조회
                    WorkGroupRecord getWorkGroupRecord = workGroupRecordMapper.findLatestWorkGroupRecordByUserId(settlementFindCompanyDto.getUserId());

                    Settlement settlement = Settlement.builder()
                            .userId(settlementFindCompanyDto.getUserId())
                            .date(date)
                            .workingTime(LocalTime.of(0, 0, 0))
                            .overTime(LocalTime.of(0, 0, 0))
                            .dateCreated(LocalDateTime.now())
                            .dateUpdated(LocalDateTime.now())
                            .workGroupRecordId(getWorkGroupRecord.getWorkGroupRecordId())
                            .build();
                    settlementMapper.insertSettlement(settlement);  //결근일때, 정산기록 insert
                }
            } else {  // 유급, 근무, 무급일때,
                if(workStatus.equals("무급")){
                    settlementIdsToDelete.add(settlementFindCompanyDto.getSettlementId());

                }else if(workStatus.equals("유급")) {
                    settlementUpdateUnpaids.add(unpaidCalculationProcess(settlementFindCompanyDto, workStatus));

                }else if(workStatus.equals("근무")) {

                }
            }
        }
    }

    //실질적인 정산 시작 메서드
    public void getMembersByCompanyAndGroup() {
        List<SettlementSearchDto> companyIdAndWorkGroupIdList = findCompanyIdAndWorkGroupIdList();  //회사 id, 근무그룹 id 리스트
        LocalDate yesterday = LocalDate.now().minusDays(1); //어제
        LocalDate beforeYesterday = yesterday.minusDays(1); //그제

        for (SettlementSearchDto settlementSearchDto : companyIdAndWorkGroupIdList) {       //회사 id, 근무그룹 id 리스트를 하나하나 뽑아냄
            // 어제 날짜에 대한 근무그룹 1개에 있는 회원 list
            List<SettlementFindCompanyDto> yesterdayResult = findCompanyAndWorkGroup(yesterday, settlementSearchDto);
            // 회원 list를 judgeMembers메서드에 넣어서 정산 시작
            settlementMembers(yesterday, yesterdayResult);

            // 그제 날짜에 대한 근무그룹 1개에 있는 회원 list
            List<SettlementFindCompanyDto> beforeResult = findCompanyAndWorkGroup(beforeYesterday, settlementSearchDto);
            // 회원 list를 judgeMembers메서드에 넣어서 정산 시작
            settlementMembers(beforeYesterday, beforeResult);
        }
    }

    //회사와 근무그룹 ID에 맞는 회원 정보 리스트
    public List<SettlementFindCompanyDto> findCompanyAndWorkGroup(LocalDate date, SettlementSearchDto settlementSearchDto) {
        return settlementMapper.findCompanyAndWorkGroup(date, settlementSearchDto);
    }

    //요일에 따라 어떤 근무인지 판단(근무/유급/무급)
    public String processWeekday(SettlementFindCompanyDto dto, LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                // 월요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getMon();
            case TUESDAY:
                // 화요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getTue();
            case WEDNESDAY:
                // 수요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getWed();
            case THURSDAY:
                // 목요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getThu();
            case FRIDAY:
                // 금요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getFri();
            case SATURDAY:
                // 토요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getSat();
            case SUNDAY:
                // 일요일에 대한 작업
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getSun();
            default:
                return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(dto.getUserId()).getSun();
        }
    }

}
