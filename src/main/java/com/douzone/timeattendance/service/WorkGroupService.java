package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.mapper.WorkGroupMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class WorkGroupService {
    private final WorkGroupMapper workGroupMapper;

    public WorkGroupService(WorkGroupMapper workGroupMapper) {
        this.workGroupMapper = workGroupMapper;
    }

    public WorkGroup insertWorkGroup(WorkGroup workGroup) {
        workGroupMapper.insertWorkGroup(workGroup);
        return workGroup;
    }

    @Transactional(readOnly = true)
    public List<WorkGroupResponseDto> findAllWorkGroupResponseDto(Long companyId) {
        return workGroupMapper.findAllWorkGroupResponseDto(companyId);
    }

    public void updateDistribution(LocalDateTime date, List<Long> userIds, Long workGroupId) {
        workGroupMapper.updateDistribution(date, userIds, workGroupId);
    }

    public void updateUserDistribution(List<Long> userIds, Long workGroupId) {
        workGroupMapper.updateUserDistribution(userIds, workGroupId);
    }

    public void deleteWorkgroup(Long workGroupId) {
        workGroupMapper.deleteWorkgroup(workGroupId);
    }

    public void deleteDistribution(List<Long> userIds) {
        workGroupMapper.deleteDistribution(userIds);
    }

    public void updateWorkGroup(WorkGroup workGroup) {
        workGroupMapper.updateWorkGroup(workGroup);
    }

    public void insertDistribution(LocalDateTime date, Long userId, Long workGroupId) {
        workGroupMapper.insertDistribution(date, userId, workGroupId);
    }

    @Transactional(readOnly = true)
    public List<Long> getUserIds(Long workGroupId) {
        return workGroupMapper.getUserIds(workGroupId);
    }

    public void updateActivation(Long workGroupId) {
        workGroupMapper.updateActivation(workGroupId);
    }

    public void applySettlementNow(Long workGroupId, List<Long> userIds) {
        workGroupMapper.applySettlementNow(workGroupId, userIds);
    }
}
