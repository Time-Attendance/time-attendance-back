package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.workgrouprecord.WorkGroupRecordRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkGroupRecordMapper {
    WorkGroupRecord findLatestWorkGroupRecordByUserId(Long userId);
    void insertWorkGroupRecord(WorkGroupRecordRequestDto workGroupRecordRequestDto);
}
