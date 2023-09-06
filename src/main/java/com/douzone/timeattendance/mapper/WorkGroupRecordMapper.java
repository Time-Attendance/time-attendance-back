package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.WorkGroupRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkGroupRecordMapper {

    void insert(WorkGroupRecord workGroupRecord);

    WorkGroupRecord findLatestWorkGroupRecordByUserId(Long userId);
}
