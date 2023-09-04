package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.dto.settlement.*;
import com.douzone.timeattendance.mapper.SettlementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SettlementService {

    private final SettlementMapper settlementMapper;

    public void insert(Settlement settlement) {
        settlementMapper.insertSettlement(settlement);
    }

    @Transactional(readOnly = true)
    public List<SettlementResponse> findAll(SettlementFindRequest settlementFindRequest){
        return settlementMapper.findAll(settlementFindRequest);
    }

    public void update(SettlementUpdateRequest settlementUpdateRequest){
        settlementMapper.updateSettlement(settlementUpdateRequest);
    }

//    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void settlementSchedule(){

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertSchedule(){

    }

    //회사와 근무그룹 ID 리스트
    public List<SettlementSearchDto> findCompanyIdAndWorkGroupIdList(){
        return settlementMapper.findCompanyIdAndWorkGroupIdList();

    }

    //회사와 근무그룹 ID에 맞는 회원 정보 리스트
    public List<SettlementFindCompanyDto> findCompanyAndWorkGroup(LocalDate date, SettlementSearchDto settlementSearchDto) {
        return settlementMapper.findCompanyAndWorkGroup(date, settlementSearchDto);
    }

}
