package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.Dept;
import com.douzone.timeattendance.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/api/findAllDepts")
    public List<Dept> findAllDepts() {
        return deptService.findAllDepts();
    }
}
