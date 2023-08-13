package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.timerecord.TimeRecordResponse;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.TimeRecordService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time-records")
@RequiredArgsConstructor
public class TimeRecordController {

    private final TimeRecordService timeRecordService;

    @PostMapping("/work")
    public ResponseEntity<Void> startWork(@LoginUser AuthInfo authInfo) {
        timeRecordService.startWork(authInfo.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    @PostMapping("/leave")
    public ResponseEntity<Void> leaveWork(@LoginUser AuthInfo authInfo) {
        timeRecordService.leaveWork(authInfo.getUserId());
        return ResponseEntity.ok()
                             .build();
    }

    /**
     * 해당 날짜의 사용자의 출퇴근 기록을 조회
     *
     * @param date     조회 날짜
     * @param authInfo 토큰 검증이 완료된 사용자의 정보
     */
    @GetMapping(value = "/me")
    public ResponseEntity<TimeRecordResponse> findMyTimeRecordByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @LoginUser AuthInfo authInfo) {
        return ResponseEntity.ok()
                             .body(timeRecordService.findTimeRecordByDate(authInfo.getUserId(), date));
    }
}
