package com.douzone.timeattendance.service;

import com.douzone.timeattendance.dto.privilege.DeletePrivilegeRequest;
import com.douzone.timeattendance.dto.privilege.FindPrivilegeResponse;
import com.douzone.timeattendance.dto.privilege.InsertPrivilegeRequest;
import com.douzone.timeattendance.mapper.PrevilegeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PrivilegeService {

    private final PrevilegeMapper previlegeMapper;

    @Transactional(readOnly = true)
    public List<FindPrivilegeResponse> findPrivilegeList(){
        return previlegeMapper.findPrivilegeList();
    }

    @Transactional(readOnly = true)
    public List<FindPrivilegeResponse> findPrivilegeByName(String name){
        return previlegeMapper.findPrivilegeByName(name);
    }

    public void deleteDeptPrivilege(DeletePrivilegeRequest request) {
        previlegeMapper.deleteDeptPrivilege(request);
    }

    public void insertDeptPrivilege(InsertPrivilegeRequest request) {
        previlegeMapper.insertDeptPrivilege(request);
    }
}
