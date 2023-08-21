package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkGroupMapper {
    List<WorkGroup> findAllWorkGroups();

    void insertWorkGroup(WorkGroup workGroup);

    WorkGroup findByWorkGroupName(String name);

    Long findLatestId();

    List<WorkGroupResponseDto> findAllWorkGroupResponseDto();

    List<WorkGroupSimpleDto> getWorkGroupSimpleInfo();
}
