package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.dto.timerange.TimeRangeRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupRequestDto;
import com.douzone.timeattendance.mapper.TimeRangeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class TimeRangeService {
    private final TimeRangeMapper timeRangeMapper;

    public TimeRangeService(TimeRangeMapper timeRangeMapper) {
        this.timeRangeMapper = timeRangeMapper;
    }

    public void insertTimeRange(TimeRange timeRange) {
        timeRangeMapper.insertTimeRange(timeRange);
    }

    public void deleteTimeRangeByWorkGroupId(Long workGroupId) {
        timeRangeMapper.deleteTimeRangeByWorkGroupId(workGroupId);
    }

    public void insertTimeRangeAll(WorkGroupRequestDto workGroupRequestDto, Long workGroupIdToBeInserted) {
        String[] timeRangeTypeArr = (String[]) workGroupRequestDto.getTimeRangeType().toArray();
        LocalTime[] startArr = (LocalTime[]) workGroupRequestDto.getStart().toArray();
        LocalTime[] endArr = (LocalTime[]) workGroupRequestDto.getEnd().toArray();

        for (int i = 0; i < timeRangeTypeArr.length; i++) {
            TimeRangeRequestDto timeRangeRequestDto = new TimeRangeRequestDto(timeRangeTypeArr[i], startArr[i], endArr[i]);
            TimeRange timeRange = new TimeRange(timeRangeRequestDto);
            timeRange.setWorkGroupId(workGroupIdToBeInserted);
            timeRangeMapper.insertTimeRange(timeRange);
        }
    }
}
