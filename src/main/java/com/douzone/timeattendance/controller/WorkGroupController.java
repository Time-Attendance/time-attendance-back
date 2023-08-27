package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.timerange.TimeRangeRequestDto;
import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import com.douzone.timeattendance.dto.workgroup.DistributionRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.service.TimeRangeService;
import com.douzone.timeattendance.service.UserService;
import com.douzone.timeattendance.service.WorkDayTypeService;
import com.douzone.timeattendance.service.WorkGroupService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

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
    public List<WorkGroupResponseDto> getWorkGroupResponseDtoList(@RequestParam(value = "companyId", required = true) Long companyId) {
        return workGroupService.findAllWorkGroupResponseDto(companyId);
    }

    //@Valid 어노테이션과 WorkGroupRequestDto 객체의 필드에 @NotNull과 같은 어노테이션을 적용하면 유효성 검증 가능합니다.
    @PostMapping("/api/workgroups")
    public String newGroup(@RequestBody @Valid WorkGroupRequestDto workGroupRequestDto) {
        WorkGroup workGroup = new WorkGroup();
        workGroup.setName(workGroupRequestDto.getName());
        workGroup.setType(workGroupRequestDto.getType());
        workGroup.setCompanyId(workGroupRequestDto.getCompanyId());

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

    @PostMapping("/api/workgroups/distribution")
    public String updateDistribution(@RequestBody DistributionRequestDto distributionRequestDto) {
        if (distributionRequestDto.getWorkGroupId() == null) {
            distributionRequestDto.setWorkGroupId(0L);
        }
        Date currentDate = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date(currentDate.getTime());
        Instant instant = utilDate.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        distributionRequestDto.setDate(localDateTime);

        workGroupService.updateDistribution(distributionRequestDto.getDate(), distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());
        workGroupService.updateUserDistribution(distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());

        return "Updated!";
    }

//    @DeleteMapping("/api/workgroups/${workGroupId}")
//    public String deleteWorkgroup() {
//
//    }
}
