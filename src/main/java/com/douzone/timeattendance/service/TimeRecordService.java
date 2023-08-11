package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.timerecord.TimeRecordResponse;
import com.douzone.timeattendance.dto.timerecord.TimeRecordUpdateDto;
import com.douzone.timeattendance.exception.timerecord.AlreadyExistsWorkRecordException;
import com.douzone.timeattendance.exception.timerecord.InvalidLeaveWorkException;
import com.douzone.timeattendance.exception.timerecord.NoSuchTimeRecordException;
import com.douzone.timeattendance.exception.user.NoSuchUserException;
import com.douzone.timeattendance.mapper.TimeRecordMapper;
import com.douzone.timeattendance.mapper.UserMapper;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeRecordService {

    private final UserMapper userMapper;
    private final TimeRecordMapper timeRecordMapper;

    /**
     * 요청 당일의 사용자의 출근 기록을 생성합니다.
     *
     * @param email 로그인 한 사용자의 이메일
     */
    public void startWork(String email) {
        User user = userMapper.findByEmail(email)
                              .orElseThrow(NoSuchUserException::new);

        //TODO: 특정 위치 및 IP만 출퇴근가능
        //TODO: 배포 여부 검증

        //중복 출근 검증
        if (existsWorkRecord(user.getUserId(), LocalDate.now())) {
            throw new AlreadyExistsWorkRecordException();
        }

        //새 출근 기록 생성
        TimeRecord timeRecord = TimeRecord.builder()
                                          .userId(user.getUserId())
                                          .date(LocalDate.now())
                                          .work(LocalTime.now())
                                          .workState("미처리") //TODO: enum 사용
                                          .build();

        timeRecordMapper.insert(timeRecord);
    }

    /**
     * 요청 당일의 사용자의 퇴근 기록을 업데이트합니다.
     *
     * @param email 로그인 한 사용자의 이메일
     */
    public void leaveWork(String email) {
        User user = userMapper.findByEmail(email)
                              .orElseThrow(NoSuchUserException::new);

        //TODO: 특정 위치 및 IP만 출퇴근가능

        //출근기록 존재여부 검증
        if (!existsWorkRecord(user.getUserId(), LocalDate.now())) {
            throw new InvalidLeaveWorkException();
        }

        //출퇴근 테이블에 퇴근 기록 업데이트
        TimeRecordUpdateDto updateParam = TimeRecordUpdateDto.builder()
                                                             .userId(user.getUserId())
                                                             .date(LocalDate.now())
                                                             .leaveWork(LocalTime.now())
                                                             .build();
        timeRecordMapper.update(updateParam);
    }

    @Transactional(readOnly = true)
    public TimeRecordResponse findTimeRecordByDate(String email, LocalDate date) {
        User user = userMapper.findByEmail(email)
                              .orElseThrow(NoSuchUserException::new);

        return timeRecordMapper.findByDate(user.getUserId(), date)
                               .map(TimeRecordResponse::new)
                               .orElseThrow(NoSuchTimeRecordException::new);
    }

    @Transactional(readOnly = true)
    public boolean existsWorkRecord(Long userId, LocalDate date) {
        return timeRecordMapper.existsByUserIdAndDate(userId, date);
    }
}
