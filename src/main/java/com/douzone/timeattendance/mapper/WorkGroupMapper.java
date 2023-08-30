package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.workgroup.WorkGroupResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface WorkGroupMapper {
    List<WorkGroup> findAllWorkGroups();

    void insertWorkGroup(WorkGroup workGroup);

    void updateWorkGroup(WorkGroup workGroup);
    WorkGroup findByWorkGroupName(String name);

    Long findLatestId();

    List<WorkGroupResponseDto> findAllWorkGroupResponseDto(Long companyId);

    void updateDistribution(LocalDateTime date, List<Long> userIds, Long workGroupId);
    void updateUserDistribution(List<Long> userIds, Long workGroupId);

    void deleteWorkgroup(Long workGroupId);

    void deleteDistribution(List<Long> userIds);
}
