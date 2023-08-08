package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Dept;
import com.douzone.timeattendance.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    private final DeptMapper deptMapper;

    public DeptService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public List<Dept> findAllDepts() {
        return deptMapper.findAllDepts();
    }
}
