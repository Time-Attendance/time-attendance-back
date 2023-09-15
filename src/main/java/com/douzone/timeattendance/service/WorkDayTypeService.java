package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.mapper.WorkDayTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkDayTypeService {
    private final WorkDayTypeMapper workDayTypeMapper;

    public WorkDayTypeService(WorkDayTypeMapper workDayTypeMapper) {
        this.workDayTypeMapper = workDayTypeMapper;
    }

    public void insertWorkDayType(WorkDayType workDayType) {
        workDayTypeMapper.insertWorkDayType(workDayType);
    }

    public void updateWorkDayType(WorkDayType workDayType) {
        workDayTypeMapper.updateWorkDayType(workDayType);
    }

    public void deleteWorkDayType(Long workGroupId) {
        workDayTypeMapper.deleteWorkDayType(workGroupId);
    }
}
