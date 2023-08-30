package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.mapper.WorkGroupMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkGroupService {
    private final WorkGroupMapper workGroupMapper;

    public WorkGroupService(WorkGroupMapper workGroupMapper) {
        this.workGroupMapper = workGroupMapper;
    }

    public List<WorkGroup> findAllWorkGroups() {
        return workGroupMapper.findAllWorkGroups();
    }

    public void insertWorkGroup(WorkGroup workGroup) {
        workGroupMapper.insertWorkGroup(workGroup);
    }

    public WorkGroup findByWorkGroupName(String name) {
        return workGroupMapper.findByWorkGroupName(name);
    }

    public Long findLatestId() {
        return workGroupMapper.findLatestId();
    }

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
}
