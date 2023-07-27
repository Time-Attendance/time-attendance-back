package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.privilege.FindPrivilegeResponse;
import com.douzone.timeattendance.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @GetMapping("/privilege")
    public List<FindPrivilegeResponse> findPrivilegeList(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            // name 파라미터가 주어졌을 경우, 해당 이름에 맞는 회원 조회
            return privilegeService.findPrivilegeByName(name);
        } else {
            // name 파라미터가 주어지지 않은 경우, 전체 목록 조회
            return privilegeService.findPrivilegeList();
        }
    }
}
