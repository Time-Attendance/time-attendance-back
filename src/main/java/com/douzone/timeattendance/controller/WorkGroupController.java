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

        //TODO: 시간범위 업데이트 방법들
        //1. DB에 저장된 거 다 지우고 수정 요청한 값으로 DB에 새로 저장(간단함. 하지만 업데이트 개념은 아님)
        timeRangeService.deleteTimeRangeByWorkGroupId(workgroupId);
        for (int i = 0; i < workGroupRequestDto.getTimeRangeType().toArray().length; i++) {
            TimeRangeRequestDto timeRangeRequestDto = new TimeRangeRequestDto((String) workGroupRequestDto.getTimeRangeType().toArray()[i], (LocalTime) workGroupRequestDto.getStart().toArray()[i], (LocalTime) workGroupRequestDto.getEnd().toArray()[i]);
            TimeRange timeRange = new TimeRange(timeRangeRequestDto);
            timeRange.setWorkGroupId(workgroupId);
            timeRangeService.insertTimeRange(timeRange);
        }
        //2. DB에 있으면 수정 또는 삭제하고, 없으면 생성(복잡함. 업데이트 개념임)


        //TODO: 근무그룹 이력 테이블에 insert

        return ResponseEntity.ok()
                             .build();
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
