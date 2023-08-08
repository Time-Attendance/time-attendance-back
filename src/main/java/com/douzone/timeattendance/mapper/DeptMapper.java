package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Dept;
import com.douzone.timeattendance.domain.WorkGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> findAllDepts();
}
