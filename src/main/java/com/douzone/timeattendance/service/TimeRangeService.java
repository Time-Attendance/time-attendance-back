package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.mapper.TimeRangeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeRangeService {
    private final TimeRangeMapper timeRangeMapper;

    public TimeRangeService(TimeRangeMapper timeRangeMapper) {
        this.timeRangeMapper = timeRangeMapper;
    }

    public List<TimeRange> findByWorkGroupId(Long workGroupId) {
        return timeRangeMapper.findByWorkGroupId(workGroupId);
    }

    public void insertTimeRange(TimeRange timeRange) {
        timeRangeMapper.insertTimeRange(timeRange);
    }
}
