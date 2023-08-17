package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.dto.privilege.DeletePrivilegeRequest;
import com.douzone.timeattendance.dto.privilege.FindPrivilegeResponse;
import com.douzone.timeattendance.dto.privilege.InsertPrivilegeRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrevilegeMapper {
    List<FindPrivilegeResponse> findPrivilegeList();
    List<FindPrivilegeResponse> findPrivilegeByName(@Param("name") String name);
    void insertDeptPrivilege(InsertPrivilegeRequest request);
    void deleteDeptPrivilege(DeletePrivilegeRequest request);
}
