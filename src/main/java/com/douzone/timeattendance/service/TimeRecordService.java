package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.timerecord.TimeRecordResponse;
import com.douzone.timeattendance.dto.timerecord.TimeRecordUpdateDto;
import com.douzone.timeattendance.exception.timerecord.AlreadyExistsWorkRecordException;
import com.douzone.timeattendance.exception.timerecord.ImpossibleLeaveWorkException;
import com.douzone.timeattendance.mapper.TimeRecordMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeRecordService {

    private final TimeRecordMapper timeRecordMapper;
    private final WorkGroupRecordService workGroupRecordService;
    private final SettlementService settlementService;

    /**
     * 요청 당일의 사용자의 출근 기록을 생성합니다.
     *
     * @param userId 사용자 id
     */
    public void startWork(Long userId) {
        //TODO: 특정 위치 및 IP만 출퇴근가능

        //중복 출근 검증
        if (existsWorkRecord(userId, LocalDate.now())) {
            throw new AlreadyExistsWorkRecordException();
        }

        //새 출근 기록 생성
        TimeRecord timeRecord = TimeRecord.builder()
                                          .userId(userId)
                                          .date(LocalDate.now())
                                          .startWork(LocalDateTime.now())
                                          .workState("미처리") //TODO: enum 사용
                                          .build();

        //회원이 소속된 근로제의 id로 가장 최근 근로제 이력을 조회함. 미배포 회원은 null 리턴
        WorkGroupRecord workGroupRecord = workGroupRecordService.findLatestWorkGroupRecordByUserId(userId);

        if (workGroupRecord == null) {
            timeRecord.setWorkState("미배포");
            timeRecordMapper.insert(timeRecord);
            return; //미배포 회원일 경우 정산하지 않음.
        }
        timeRecordMapper.insert(timeRecord);

        //임시 정산 생성
        Settlement settlement = Settlement.builder()
                                          .date(timeRecord.getDate())
                                          .workingTime(LocalTime.MIN)
                                          .overTime(LocalTime.MIN)
                                          .dateCreated(LocalDateTime.now())
                                          .dateUpdated(LocalDateTime.now())
                                          .userId(userId)
                                          .workGroupRecordId(workGroupRecord.getWorkGroupRecordId())
                                          .build();

        settlementService.insert(settlement);
    }

    /**
     * 요청 당일의 사용자의 퇴근 기록을 업데이트합니다.
     *
     * @param userId 사용자 id
     */
    public void leaveWork(Long userId) {
        //TODO: 특정 위치 및 IP만 출퇴근가능

        //출근기록 존재여부 검증
        if (!existsWorkRecord(userId, LocalDate.now())) {
            throw new ImpossibleLeaveWorkException();
        }

        //출퇴근 테이블에 퇴근 기록 업데이트
        TimeRecordUpdateDto updateParam = TimeRecordUpdateDto.builder()
                                                             .userId(userId)
                                                             .date(LocalDate.now())
                                                             .leaveWork(LocalDateTime.now())
                                                             .build();
        timeRecordMapper.update(updateParam);
    }

    @Transactional(readOnly = true)
    public TimeRecordResponse findTimeRecordByDate(Long userId, LocalDate date) {
        return timeRecordMapper.findByDate(userId, date)
                               .map(TimeRecordResponse::new)
                               .orElseGet(TimeRecordResponse::new);
    }

    @Transactional(readOnly = true)
    public boolean existsWorkRecord(Long userId, LocalDate date) {
        return timeRecordMapper.existsByUserIdAndDate(userId, date);
    }
}
