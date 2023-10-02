package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.TimeRange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeRangeMapper {
    void insertTimeRange(TimeRange timeRange);

    void deleteTimeRangeByWorkGroupId(Long workGroupId);
}
