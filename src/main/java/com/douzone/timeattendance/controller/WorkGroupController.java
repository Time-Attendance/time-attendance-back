package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.timerange.TimeRangeRequestDto;
import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupSimpleDto;
import com.douzone.timeattendance.service.TimeRangeService;
import com.douzone.timeattendance.service.UserService;
import com.douzone.timeattendance.service.WorkDayTypeService;
import com.douzone.timeattendance.service.WorkGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.*;
import java.util.List;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
public class WorkGroupController {
    private final WorkGroupService workGroupService;
    private final WorkDayTypeService workDayTypeService;
    private final TimeRangeService timeRangeService;
    private final UserService userService;

    public WorkGroupController(WorkGroupService workGroupService, WorkDayTypeService workDayTypeService, TimeRangeService timeRangeService, UserService userService) {
        this.workGroupService = workGroupService;
        this.workDayTypeService = workDayTypeService;
        this.timeRangeService = timeRangeService;
        this.userService = userService;
    }

    @GetMapping("/api/workgroups")
    public List<WorkGroupResponseDto> getWorkGroupResponseDtoList() {
        return workGroupService.findAllWorkGroupResponseDto();
    }

    @GetMapping("/api/workgroups-simple")
    public List<WorkGroupSimpleDto> getWorkGroupSimpleInfo() {
        return workGroupService.getWorkGroupSimpleInfo();
    }

    @PostMapping("/api/workgroups")
    public String newGroup(@RequestBody WorkGroupRequestDto workGroupRequestDto) {
        WorkGroup workGroup = new WorkGroup();
        workGroup.setName(workGroupRequestDto.getName());
        workGroup.setType(workGroupRequestDto.getType());

        Date date = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date(date.getTime());
        Instant instant = utilDate.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        workGroup.setDateCreated(localDateTime);
        workGroup.setDateUpdated(localDateTime);
        workGroup.setIsDeleted(false);
        workGroup.setIsOn(true);
        workGroupService.insertWorkGroup(workGroup);
        Long workGroupIdToBeInserted = workGroupService.findLatestId();

        WorkDayTypeRequestDto workDayTypeRequestDto = workGroupRequestDto.getWorkDayType();
        WorkDayType workDayType = new WorkDayType(workDayTypeRequestDto);
        workDayType.setWorkGroupId(workGroupIdToBeInserted);
        workDayTypeService.insertWorkDayType(workDayType);

        for (int i = 0; i < workGroupRequestDto.getTimeRangeType().toArray().length; i++) {
            TimeRangeRequestDto timeRangeRequestDto = new TimeRangeRequestDto((String) workGroupRequestDto.getTimeRangeType().toArray()[i], (LocalTime) workGroupRequestDto.getStart().toArray()[i], (LocalTime) workGroupRequestDto.getEnd().toArray()[i]);
            TimeRange timeRange = new TimeRange(timeRangeRequestDto);
            timeRange.setWorkGroupId(workGroupIdToBeInserted);
            timeRangeService.insertTimeRange(timeRange);
        }

        return "All inserted!";
    }
}
