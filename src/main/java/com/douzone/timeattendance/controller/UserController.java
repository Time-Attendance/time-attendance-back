package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.user.LoginUserResponse;
import com.douzone.timeattendance.dto.user.MyPageSelectedTimeRecordResponse;
import com.douzone.timeattendance.dto.user.UserCreateRequest;
import com.douzone.timeattendance.dto.user.UserResponse;
import com.douzone.timeattendance.dto.user.UserSearchDto;
import com.douzone.timeattendance.dto.user.UserUpdateRequest;
import com.douzone.timeattendance.dto.user.UserWorkGroupResponse;
import com.douzone.timeattendance.dto.user.MyPageWeeklyTimeRecordResponse;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.TimeRecordService;
import com.douzone.timeattendance.service.UserService;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TimeRecordService timeRecordService;

    /**
     * 회원 목록 조회
     * @param searchDto 회원 조회 조건
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(
            @LoginUser AuthInfo authInfo,
            @ModelAttribute @Valid UserSearchDto searchDto) {
        return ResponseEntity.ok()
                             .body(userService.getUsers(searchDto));
    }

    /**
     * 로그인 한 사용자 정보를 가져올 수 있는 샘플 코드입니다. LoginUser 어노테이션과 AuthInfo 객체를 핸들러 메서드의 인자로 선언하면, 요청을 보낸 사용자의 정보를 알 수 있습니다.
     * authInfo 객체를 통해 DB에서 사용자를 조회한 후, 비즈니스 로직을 처리하면 됩니다.
     *
     * @param authInfo 토큰 검증이 완료된 사용자의 정보
     */
    @GetMapping("/sample")
    public ResponseEntity<Void> sample(@LoginUser AuthInfo authInfo) {
        System.out.println("로그인 한 사용자의 userId = " + authInfo.getUserId());
        return ResponseEntity.ok()
                             .build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        userService.signup(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    /**
     * 현재 로그인 한 사용자의 정보를 응답하는 핸들러입니다.
     *
     * @param authInfo 토큰 검증이 완료된 사용자의 정보
     * @return LoginUserResponse 객체
     */
    @GetMapping("/me")
    public ResponseEntity<LoginUserResponse> loginUserInfo(@LoginUser AuthInfo authInfo) {
        return ResponseEntity.ok()
                             .body(userService.loginUserInfo(authInfo));
    }

    /**
     * 단일 회원 권한 변경
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<Void> updateUserRole(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long userId,
            @RequestParam String role) {
        userService.updateUser(userId, role);
        return ResponseEntity.ok()
                             .build();
    }

    /**
     * 다중 회원 권한 변경
     */
    @PatchMapping
    public ResponseEntity<Void> updateUsersRole(
            @LoginUser AuthInfo authInfo,
            @RequestBody List<UserUpdateRequest> userUpdateRequests) {
        userService.updateUsers(userUpdateRequests);
        return ResponseEntity.ok()
                             .build();
    }

    @GetMapping("/{userId}/workgroup")
    public ResponseEntity<UserWorkGroupResponse> getUserWorkGroup(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long userId) {
        return ResponseEntity.ok()
                             .body(userService.getUserWorkGroup(userId));
    }

    /**
     * 사용자의 주간 근무기록 조회
     */
    @GetMapping(value = "/{userId}/time-records/weekly")
    public ResponseEntity<MyPageWeeklyTimeRecordResponse> findWeeklyTimeRecords(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate) {
        return ResponseEntity.ok()
                             .body(timeRecordService.findWeeklyTimeRecordByUserId(userId, startDate));
    }

    /**
     * 지정 날짜 범위의 사용자 출퇴근 기록 조회
     */
    @GetMapping(value = "/{userId}/time-records")
    public ResponseEntity<MyPageSelectedTimeRecordResponse> findTimeRecordByUserIdBetweenStartDateAndEndDate(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return ResponseEntity.ok()
                             .body(timeRecordService.findTimeRecordByUserIdBetweenStartDateAndEndDate(userId, startDate, endDate));
    }
}
