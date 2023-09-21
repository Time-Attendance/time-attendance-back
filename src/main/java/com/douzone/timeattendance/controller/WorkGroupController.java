package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import com.douzone.timeattendance.dto.workgroup.DistributionRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.TimeRangeService;
import com.douzone.timeattendance.service.WorkDayTypeService;
import com.douzone.timeattendance.service.WorkGroupRecordService;
import com.douzone.timeattendance.service.WorkGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class WorkGroupController {
    private final WorkGroupService workGroupService;
    private final WorkDayTypeService workDayTypeService;
    private final TimeRangeService timeRangeService;
    private final WorkGroupRecordService workGroupRecordService;

    public WorkGroupController(WorkGroupService workGroupService, WorkDayTypeService workDayTypeService, TimeRangeService timeRangeService, WorkGroupRecordService workGroupRecordService) {
        this.workGroupService = workGroupService;
        this.workDayTypeService = workDayTypeService;
        this.timeRangeService = timeRangeService;
        this.workGroupRecordService = workGroupRecordService;
    }

    @GetMapping("/api/workgroups")
    public ResponseEntity<List<WorkGroupResponseDto>> getWorkGroupResponseDtoList(@LoginUser AuthInfo authInfo, @RequestParam(value = "companyId", required = true) Long companyId) {
        return ResponseEntity.ok().body(workGroupService.findAllWorkGroupResponseDto(companyId));
    }

    @PostMapping("/api/workgroups")
    public ResponseEntity<Void> newGroup(@LoginUser AuthInfo authInfo, @RequestBody @Valid WorkGroupRequestDto workGroupRequestDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        WorkGroup workGroup = WorkGroup.builder().name(workGroupRequestDto.getName()).type(workGroupRequestDto.getType()).companyId(workGroupRequestDto.getCompanyId()).isDeleted(false).isOn(true).dateCreated(localDateTime).dateUpdated(localDateTime).build();
        workGroupService.insertWorkGroup(workGroup);
        Long workGroupIdToBeInserted = workGroup.getWorkGroupId();

        WorkDayTypeRequestDto workDayTypeRequestDto = workGroupRequestDto.getWorkDayType();
        WorkDayType workDayType = new WorkDayType(workDayTypeRequestDto);
        workDayType.setWorkGroupId(workGroupIdToBeInserted);
        workDayTypeService.insertWorkDayType(workDayType);

        timeRangeService.insertTimeRangeAll(workGroupRequestDto, workGroupIdToBeInserted);
        workGroupRecordService.saveWorkGroupRecord(workGroupRequestDto, workGroupIdToBeInserted);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/workgroups/{workgroupId}")
    public ResponseEntity<Void> updateWorkGroup(@LoginUser AuthInfo authInfo, @PathVariable Long workgroupId, @RequestBody @Valid WorkGroupRequestDto workGroupRequestDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        WorkGroup workGroup = WorkGroup.builder().workGroupId(workgroupId).name(workGroupRequestDto.getName()).type(workGroupRequestDto.getType()).dateUpdated(localDateTime).build();
        workGroupService.updateWorkGroup(workGroup);

        WorkDayTypeRequestDto workDayTypeRequestDto = workGroupRequestDto.getWorkDayType();
        WorkDayType workDayType = new WorkDayType(workDayTypeRequestDto);
        workDayType.setWorkGroupId(workgroupId);
        workDayTypeService.updateWorkDayType(workDayType);

        // DB에 저장된 거 다 지우고 수정 요청한 값으로 DB에 새로 저장(간단함. 하지만 업데이트 개념은 아님)
        timeRangeService.deleteTimeRangeByWorkGroupId(workgroupId);
        timeRangeService.insertTimeRangeAll(workGroupRequestDto, workgroupId);
        workGroupRecordService.saveWorkGroupRecord(workGroupRequestDto, workgroupId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/workgroups/distribution/{applyNow}")
    public ResponseEntity<Void> updateDistribution(@LoginUser AuthInfo authInfo, @PathVariable("applyNow") Boolean applyNow, @RequestBody DistributionRequestDto distributionRequestDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        distributionRequestDto.setDate(localDateTime);

        workGroupService.updateDistribution(distributionRequestDto.getDate(), distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());
        workGroupService.updateUserDistribution(distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());

        if (applyNow) {
            workGroupService.applySettlementNow(distributionRequestDto.getWorkGroupId(), distributionRequestDto.getUserIds());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/workgroups/distribution")
    public ResponseEntity<Void> insertDistribution(@LoginUser AuthInfo authInfo, @RequestBody DistributionRequestDto distributionRequestDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        distributionRequestDto.setDate(localDateTime);
        List<Long> userIds = distributionRequestDto.getUserIds();

        for (int i = 0; i < userIds.size(); i++) {
            workGroupService.insertDistribution(distributionRequestDto.getDate(), userIds.get(i), distributionRequestDto.getWorkGroupId());
        }

        workGroupService.updateUserDistribution(distributionRequestDto.getUserIds(), distributionRequestDto.getWorkGroupId());

        return ResponseEntity.ok().build();
    }

    // JSON body
    @DeleteMapping("/api/workgroups/distribution/{userIds}")
    public ResponseEntity<Void> deleteDistribution(@LoginUser AuthInfo authInfo, @PathVariable("userIds") List<Long> userIds) {
        workGroupService.deleteDistribution(userIds);
        workGroupService.updateUserDistribution(userIds, 0L);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/api/workgroups/{workGroupId}")
    public ResponseEntity<Void> deleteWorkgroup(@LoginUser AuthInfo authInfo, @PathVariable("workGroupId") Long workGroupId) {
        workGroupService.deleteWorkgroup(workGroupId);
        workDayTypeService.deleteWorkDayType(workGroupId);
        timeRangeService.deleteTimeRangeByWorkGroupId(workGroupId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/workgroups/distribution/{selectedWorkGroupId}")
    public ResponseEntity<List<Long>> getUserIds(@LoginUser AuthInfo authInfo, @PathVariable("selectedWorkGroupId") Long workGroupId) {

        return ResponseEntity.ok().body(workGroupService.getUserIds(workGroupId));
    }

    @PutMapping("/api/workgroups/activation/{workgroupId}")
    public ResponseEntity<Void> updateActivation(@LoginUser AuthInfo authInfo, @PathVariable("workgroupId") Long workgroupId) {
        workGroupService.updateActivation(workgroupId);

        return ResponseEntity.ok().build();
    }
}
