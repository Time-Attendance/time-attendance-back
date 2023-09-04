package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.TimeRange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeRangeMapper {
    List<TimeRange> findByWorkGroupId(Long workGroupId);

    void insertTimeRange(TimeRange timeRange);

    void updateTimeRange(TimeRange timeRange);

    void deleteTimeRangeByWorkGroupId(Long workGroupId);
}
