package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.WorkDayType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkDayTypeMapper {
    WorkDayType findByWorkGroupId(Long workGroupId);

    void insertWorkDayType(WorkDayType workDayType);
    void updateWorkDayType(WorkDayType workDayType);
}
