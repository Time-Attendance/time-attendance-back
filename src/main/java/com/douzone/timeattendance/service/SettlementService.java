package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.settlement.*;
import com.douzone.timeattendance.mapper.SettlementMapper;
import com.douzone.timeattendance.mapper.TimeRecordMapper;
import com.douzone.timeattendance.mapper.WorkGroupRecordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
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

    @Scheduled(cron = "0 */1 * * * *")
    public void settlementSchedule() {
        getMembersByCompanyAndGroup();
    }

    //근무, 유급, 무급인 회원들을 모아서 한번에 update, delete를 하는 메서드
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertSchedule(List<SettlementUpdateDto> settlementUpdateWorks, List<SettlementUpdateDto> settlementUpdatePaids, List<Long> settlementIdsToDelete) {
        if (settlementUpdateWorks != null) {
            settlementMapper.updateSettlementList(settlementUpdateWorks);
        }
        if (settlementUpdatePaids != null) {
            settlementMapper.updateSettlementList(settlementUpdatePaids);
        }
        if (settlementIdsToDelete != null) {
            settlementMapper.deleteSettlementList(settlementIdsToDelete);
        }

    }

    //회사와 근무그룹 ID 리스트
    public List<SettlementSearchDto> findCompanyIdAndWorkGroupIdList() {
        return settlementMapper.findCompanyIdAndWorkGroupIdList();

    }

    //근무일때, 정산 로직
    public SettlementUpdateDto workCalculationProcess(SettlementFindCompanyDto settlementFindCompanyDto, String workStatus) {
        LocalDateTime startWork = settlementFindCompanyDto.getStartWork();  //출근 시각
        LocalDateTime leaveWork = settlementFindCompanyDto.getLeaveWork();  //퇴근 시각
        List<Integer> workIndexList = new ArrayList<>();    //근무시간 인덱스 리스트
        List<Integer> restIndexList = new ArrayList<>();    //휴게시간 인덱스 리스트
        List<Integer> approveIndexList = new ArrayList<>(); //승인근로 인덱스 리스트
        String[] timeRangeList = settlementFindCompanyDto.getTimeRangeType().replace(" ", "").split(",");     //시간 종류 배열
        String[] startList = settlementFindCompanyDto.getStart().replace(" ", "").split(",");    //시작 시간 배열
        String[] endList = settlementFindCompanyDto.getEnd().replace(" ", "").split(",");        //종료 시간 배열
        LocalTime[] startTimeList = new LocalTime[startList.length];    //시작 시간 LocalTime형 배열
        LocalTime[] endTimeList = new LocalTime[endList.length];        //종료 시간 LocalTime형 배열
        String workState = "정상처리";  //근무상태 기본값을 정상처리로 세팅

        for (int i = 0; i < startList.length; i++) {
            startTimeList[i] = LocalTime.parse(startList[i]);
        }
        for (int i = 0; i < endList.length; i++) {
            endTimeList[i] = LocalTime.parse(endList[i]);
        }

        //insert할 dto 세팅
        LocalTime startTime = LocalTime.of(0, 0);
        LocalTime endTime = LocalTime.of(0, 0);
        LocalTime workingTime = LocalTime.of(0, 0);
        LocalTime overTime = LocalTime.of(0, 0);
        ;                //정산 테이블

        for (int i = 0; i < timeRangeList.length; i++) {
            if (timeRangeList[i].equals("근무")) {
                workIndexList.add(i);
            } else if (timeRangeList[i].equals("휴게")) {
                restIndexList.add(i);
            } else if (timeRangeList[i].equals("승인")) {
                approveIndexList.add(i);
            }
        }

        //근무 시작 시간 로직

        if (workIndexList.size() > 1) {   //시차근로제일때,
            int maxIdx = 0;
            int minIdx = 0;
            for (int i = 0; i < workIndexList.size(); i++) {
                if (startTimeList[i].isBefore(startTimeList[minIdx])) {
                    minIdx = i;
                } else if (startTimeList[i].isAfter(startTimeList[maxIdx])) {
                    maxIdx = i;
                }
            }
            if (startWork.toLocalTime().isBefore(startTimeList[minIdx]) || startWork.toLocalTime().equals(startTimeList[minIdx])) {
                startTime = startTimeList[minIdx];
            } else if (startTimeList[minIdx].isBefore(startWork.toLocalTime()) &&
                    (startWork.toLocalTime().isBefore(startTimeList[maxIdx]) || startWork.toLocalTime().equals(startTimeList[maxIdx]))) {
                startTime = startWork.toLocalTime();
            } else if (startTimeList[maxIdx].isBefore(startWork.toLocalTime())) {
                startTime = startWork.toLocalTime();
                workState = "근태이상";
            }
        } else if (workIndexList.size() == 1) {  //일반 또는 시차근로제일때,
            if (startWork.toLocalTime().isBefore(startTimeList[0]) || startWork.toLocalTime().equals(startTimeList[0])) {
                startTime = startTimeList[0];
            } else if (startWork.toLocalTime().isAfter(startTimeList[0])) {
                startTime = startWork.toLocalTime();
                workState = "근태이상";
            }
        }

        //근무 종료 시간 로직

        if (leaveWork == null) {
            if (ChronoUnit.DAYS.between(LocalDate.now(), settlementFindCompanyDto.getDate()) >= 2) {
                SettlementUpdateDto updateDto = SettlementUpdateDto.builder()
                        .settlementId(settlementFindCompanyDto.getSettlementId())
                        .startTime(startTime)
                        .workingTime(LocalTime.of(0, 0))
                        .overTime(LocalTime.of(0, 0))
                        .dayType(workStatus)
                        .dateUpdated(LocalDateTime.now())
                        .build();
                return updateDto;
            }
        } else {
            endTime = leaveWork.toLocalTime();
        }

        //소정 근로시간 계산 로직
        LocalTime sum = LocalTime.of(0, 0);
        for (Integer i : restIndexList) {
            if ((startTime.isBefore(startTimeList[i]) || startTime.equals(startTimeList[i])) &&
                    (endTime.isAfter(endTimeList[i]) || endTime.equals(endTimeList[i]))) {
                sum = timePlus(sum, timeDiffer(startTimeList[i], endTimeList[i]));
            } else if (startTime.isAfter(startTimeList[i]) &&
                    (endTime.isAfter(endTimeList[i]) || endTime.equals(endTimeList[i]))) {
                sum = timePlus(sum, timeDiffer(startTime, endTimeList[i]));
            } else if ((startTime.isBefore(startTimeList[i]) || startTime.equals(startTimeList[i])) &&
                    endTime.isBefore(endTimeList[i])) {
                sum = timePlus(sum, timeDiffer(startTimeList[i], endTime));
            }
        }

        if (timeDiffer(startTime, endTime).isBefore(timeDiffer(startTimeList[0], endTimeList[0]))) {
            workingTime = timeDiffer(sum, timeDiffer(startTime, endTime));
            workState = "근태이상";
        } else {
            LocalTime differ = timeDiffer(timeDiffer(startTimeList[0], endTimeList[0]), timeDiffer(startTime, endTime));
            workingTime = timeDiffer(sum, timeDiffer(startTimeList[0], endTimeList[0]));
            for (Integer i : approveIndexList) {
                if ((startTimeList[i].isBefore(endTime) || startTimeList[i].equals(endTime)) &&
                        (endTimeList[i].isAfter(endTime) || endTimeList[i].equals(endTime))) {
                    overTime = differ;
                } else if (endTimeList[i].isBefore(endTime)) {
                    overTime = timeDiffer(workingTime, timeDiffer(startTime, endTimeList[i]));
                } else if (endTime.isBefore(startTimeList[i])) {
                    overTime = LocalTime.of(0, 0);
                }
            }
        }


        SettlementUpdateDto settlementUpdateDto = SettlementUpdateDto.builder()
                .settlementId(settlementFindCompanyDto.getSettlementId())
                .startTime(startTime)
                .endTime(endTime)
                .workingTime(workingTime)
                .overTime(overTime)
                .dayType(workStatus)
                .dateUpdated(LocalDateTime.now())
                .build();
        return settlementUpdateDto;
    }

    //유급일때, 정산 계산 로직
    public SettlementUpdateDto paidCalculationProcess(SettlementFindCompanyDto settlementFindCompanyDto, String workStatus) {

        LocalDateTime startTime = settlementFindCompanyDto.getStartWork();
        LocalDateTime endTime = settlementFindCompanyDto.getLeaveWork();
        Duration duration = Duration.between(startTime, endTime);

        SettlementUpdateDto settlementUpdateDto = SettlementUpdateDto.builder()
                .settlementId(settlementFindCompanyDto.getSettlementId())
                .startTime(startTime.toLocalTime())
                .endTime(endTime.toLocalTime())
                .workingTime(LocalTime.of(0, 0))
                .overTime(LocalTime.ofSecondOfDay(duration.getSeconds()))
                .dayType(workStatus)
                .dateUpdated(LocalDateTime.now())
                .build();
        return settlementUpdateDto;
    }

    //회원 list를 보고 회원들 한명씩 정산하는 메서드
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void settlementMembers(LocalDate date, List<SettlementFindCompanyDto> result) {
        List<SettlementUpdateDto> settlementUpdateWorks = new ArrayList<>();    //근무일때, 정산 정보 모음
        List<SettlementUpdateDto> settlementUpdatePaids = new ArrayList<>();  //유급일때, 정산 정보 모음
        List<Long> settlementIdsToDelete = new ArrayList<>();   // 무급일때, 삭제할 정산 id들을 모은 list
        List<String> timeRecordUpdate = new ArrayList<>();

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
                            .workingTime(LocalTime.of(0, 0))
                            .overTime(LocalTime.of(0, 0))
                            .dateCreated(LocalDateTime.now())
                            .dateUpdated(LocalDateTime.now())
                            .workGroupRecordId(getWorkGroupRecord.getWorkGroupRecordId())
                            .build();
                    settlementMapper.insertSettlement(settlement);  //결근일때, 정산기록 insert
                }
            } else {  // 유급, 근무, 무급일때,
                if (workStatus.equals("무급")) {
                    settlementIdsToDelete.add(settlementFindCompanyDto.getSettlementId());

                } else if (workStatus.equals("유급")) {
                    settlementUpdatePaids.add(paidCalculationProcess(settlementFindCompanyDto, workStatus));

                } else if (workStatus.equals("근무")) {
                    settlementUpdateWorks.add(workCalculationProcess(settlementFindCompanyDto, workStatus));
                }
            }
        }
        insertSchedule(settlementUpdateWorks, settlementUpdatePaids, settlementIdsToDelete);
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

    //end - start의 결과값인 LocalTime이 반환되는 함수
    public LocalTime timeDiffer(LocalTime start, LocalTime end) {

        if (end.isBefore(start)) {
            end = end.plusHours(24);
        }
        LocalTime timeDifference = end.minusHours(start.getHour()).minusMinutes(start.getMinute());

        return timeDifference;
    }

    //start+end의 값인 LocalTime이 반환되는 함수
    public LocalTime timePlus(LocalTime start, LocalTime end) {
        LocalTime result = start.plusHours(end.getHour()).plusMinutes(end.getMinute());
        return result;
    }
}
