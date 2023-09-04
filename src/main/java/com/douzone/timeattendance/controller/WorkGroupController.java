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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<WorkGroupResponseDto>> getWorkGroupResponseDtoList(@RequestParam(value = "companyId", required = true) Long companyId) {

        return ResponseEntity.ok()
                .body(workGroupService.findAllWorkGroupResponseDto(companyId));
    }

    @PostMapping("/api/workgroups")
    public ResponseEntity<Void> newGroup(@RequestBody WorkGroupRequestDto workGroupRequestDto) {
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

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/workgroups/{workgroupId}")
    public ResponseEntity<Void> updateWorkGroup(
            @PathVariable Long workgroupId,
            @RequestBody @Valid WorkGroupRequestDto workGroupRequestDto) {
        WorkGroup workGroup = new WorkGroup();
        workGroup.setWorkGroupId(workgroupId);
        workGroup.setName(workGroupRequestDto.getName());
        workGroup.setType(workGroupRequestDto.getType());
        workGroup.setDateUpdated(LocalDateTime.now());
        workGroupService.updateWorkGroup(workGroup);

        WorkDayTypeRequestDto workDayTypeRequestDto = workGroupRequestDto.getWorkDayType();
        WorkDayType workDayType = new WorkDayType(workDayTypeRequestDto);
        workDayType.setWorkGroupId(workgroupId);
        workDayTypeService.updateWorkDayType(workDayType);

        //1. DB에 저장된 거 다 지우고 수정 요청한 값으로 DB에 새로 저장(간단함. 하지만 업데이트 개념은 아님)
        timeRangeService.deleteTimeRangeByWorkGroupId(workgroupId);
        for (int i = 0; i < workGroupRequestDto.getTimeRangeType().toArray().length; i++) {
            TimeRangeRequestDto timeRangeRequestDto = new TimeRangeRequestDto((String) workGroupRequestDto.getTimeRangeType().toArray()[i], (LocalTime) workGroupRequestDto.getStart().toArray()[i], (LocalTime) workGroupRequestDto.getEnd().toArray()[i]);
            TimeRange timeRange = new TimeRange(timeRangeRequestDto);
            timeRange.setWorkGroupId(workgroupId);
            timeRangeService.insertTimeRange(timeRange);
        }

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/workgroups/distribution")
    public ResponseEntity<Void> updateDistribution(@RequestBody DistributionRequestDto distributionRequestDto) {
        Date currentDate = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date(currentDate.getTime());
        Instant instant = utilDate.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        distributionRequestDto.setDate(localDateTime);

        workGroupService.updateDistribution(distributionRequestDto.getDate(), distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());
        workGroupService.updateUserDistribution(distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());

        return ResponseEntity.ok()
                .build();
    }

    @PostMapping("/api/workgroups/distribution")
    public ResponseEntity<Void> insertDistribution(@RequestBody DistributionRequestDto distributionRequestDto) {
        Date currentDate = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date(currentDate.getTime());
        Instant instant = utilDate.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        distributionRequestDto.setDate(localDateTime);

        List<Long> userIds = distributionRequestDto.getUserIds();

        for (int i = 0; i < userIds.size(); i++) {
            workGroupService.insertDistribution(distributionRequestDto.getDate(), userIds.get(i), distributionRequestDto.getWorkGroupId());
        }

        workGroupService.updateUserDistribution(distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());

        return ResponseEntity.ok()
                .build();
    }

    // JSON body
    @DeleteMapping("/api/workgroups/distribution/{userIds}")
    public ResponseEntity<Void> deleteDistribution(@PathVariable("userIds") List<Long> userIds) {
        workGroupService.deleteDistribution(userIds);
        workGroupService.updateUserDistribution(userIds, 0L);

        return ResponseEntity.ok()
                .build();
    }


    @DeleteMapping("/api/workgroups/{workGroupId}")
    public ResponseEntity<Void> deleteWorkgroup(@PathVariable("workGroupId") Long workGroupId) {
        workGroupService.deleteWorkgroup(workGroupId);
        workDayTypeService.deleteWorkDayType(workGroupId);
        timeRangeService.deleteTimeRangeByWorkGroupId(workGroupId);

        return ResponseEntity.ok()
                .build();
    }
}
