package com.douzone.timeattendance.service;

import com.douzone.timeattendance.dto.privilege.FindPrivilegeResponse;
import com.douzone.timeattendance.mapper.PrevilegeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegeService {

    private final PrevilegeMapper previlegeMapper;

    public List<FindPrivilegeResponse> findPrivilegeList(){
        return previlegeMapper.findPrivilegeList();
    };

    public List<FindPrivilegeResponse> findPrivilegeByName(String name){
        return previlegeMapper.findPrivilegeByName(name);
    }
}
