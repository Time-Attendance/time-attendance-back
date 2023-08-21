package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.mapper.WorkDayTypeMapper;
import org.springframework.stereotype.Service;

@Service
public class WorkDayTypeService {
    private final WorkDayTypeMapper workDayTypeMapper;

    public WorkDayTypeService(WorkDayTypeMapper workDayTypeMapper) {
        this.workDayTypeMapper = workDayTypeMapper;
    }

    public WorkDayType findByWorkGroupId(Long workGroupId) {
        return workDayTypeMapper.findByWorkGroupId(workGroupId);
    }

    public void insertWorkDayType(WorkDayType workDayType) {
        workDayTypeMapper.insertWorkDayType(workDayType);
    }
}
