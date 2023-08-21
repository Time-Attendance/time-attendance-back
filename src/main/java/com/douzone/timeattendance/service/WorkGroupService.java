package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupSimpleDto;
import com.douzone.timeattendance.mapper.WorkGroupMapper;
import org.springframework.stereotype.Service;

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

    public List<WorkGroupResponseDto> findAllWorkGroupResponseDto() {
        return workGroupMapper.findAllWorkGroupResponseDto();
    }

    public  List<WorkGroupSimpleDto> getWorkGroupSimpleInfo() {
        return workGroupMapper.getWorkGroupSimpleInfo();
    }
}
