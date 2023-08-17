package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.dto.timerecord.TimeRecordResponse;
import com.douzone.timeattendance.dto.timerecord.TimeRecordUpdateDto;
import com.douzone.timeattendance.exception.timerecord.AlreadyExistsWorkRecordException;
import com.douzone.timeattendance.exception.timerecord.ImpossibleLeaveWorkException;
import com.douzone.timeattendance.exception.timerecord.NoSuchTimeRecordException;
import com.douzone.timeattendance.mapper.TimeRecordMapper;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeRecordService {

    private final TimeRecordMapper timeRecordMapper;

    /**
     * 요청 당일의 사용자의 출근 기록을 생성합니다.
     *
     * @param userId 사용자 id
     */
    public void startWork(Long userId) {
        //TODO: 특정 위치 및 IP만 출퇴근가능
        //TODO: 배포 여부 검증

        //중복 출근 검증
        if (existsWorkRecord(userId, LocalDate.now())) {
            throw new AlreadyExistsWorkRecordException();
        }

        //새 출근 기록 생성
        TimeRecord timeRecord = TimeRecord.builder()
                                          .userId(userId)
                                          .date(LocalDate.now())
                                          .startWork(LocalTime.now())
                                          .workState("미처리") //TODO: enum 사용
                                          .build();

        timeRecordMapper.insert(timeRecord);
    }

    /**
     * 요청 당일의 사용자의 퇴근 기록을 업데이트합니다.
     *
     * @param userId 사용자 id
     */
    public void leaveWork(Long userId) {
        //TODO: 특정 위치 및 IP만 출퇴근가능
        //TODO: 배포 여부 검증

        //출근기록 존재여부 검증
        if (!existsWorkRecord(userId, LocalDate.now())) {
            throw new ImpossibleLeaveWorkException();
        }

        //출퇴근 테이블에 퇴근 기록 업데이트
        TimeRecordUpdateDto updateParam = TimeRecordUpdateDto.builder()
                                                             .userId(userId)
                                                             .date(LocalDate.now())
                                                             .leaveWork(LocalTime.now())
                                                             .build();
        timeRecordMapper.update(updateParam);
    }

    @Transactional(readOnly = true)
    public TimeRecordResponse findTimeRecordByDate(Long userId, LocalDate date) {
        return timeRecordMapper.findByDate(userId, date)
                               .map(TimeRecordResponse::new)
                               .orElseThrow(NoSuchTimeRecordException::new);
    }

    @Transactional(readOnly = true)
    public boolean existsWorkRecord(Long userId, LocalDate date) {
        return timeRecordMapper.existsByUserIdAndDate(userId, date);
    }
}
