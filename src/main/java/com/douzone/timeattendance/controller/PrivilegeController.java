package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.privilege.DeletePrivilegeRequest;
import com.douzone.timeattendance.dto.privilege.FindPrivilegeResponse;
import com.douzone.timeattendance.dto.privilege.InsertPrivilegeRequest;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @GetMapping("/privilege")
    public ResponseEntity<List<FindPrivilegeResponse>> findPrivilegeList(@LoginUser AuthInfo authInfo, @RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            // name 파라미터가 주어졌을 경우, 해당 이름에 맞는 회원 조회
            return ResponseEntity.ok().body(privilegeService.findPrivilegeByName(name));
        } else {
            // name 파라미터가 주어지지 않은 경우, 전체 목록 조회
            return ResponseEntity.ok().body(privilegeService.findPrivilegeList());
        }
    }

    @DeleteMapping("/privilege")
    public ResponseEntity<Void> deletePrivilege(@LoginUser AuthInfo authInfo,@RequestBody DeletePrivilegeRequest request) {
        privilegeService.deleteDeptPrivilege(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/privilege")
    public ResponseEntity<Void> insertPrivilege(@LoginUser AuthInfo authInfo,@RequestBody InsertPrivilegeRequest request) {
        privilegeService.insertDeptPrivilege(request);
        return ResponseEntity.ok().build();
    }


}
