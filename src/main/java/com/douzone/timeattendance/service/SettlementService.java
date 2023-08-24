package com.douzone.timeattendance.service;

import com.douzone.timeattendance.dto.settlement.SettlementFindRequest;
import com.douzone.timeattendance.dto.settlement.SettlementResponse;
import com.douzone.timeattendance.dto.settlement.SettlementUpdateRequest;
import com.douzone.timeattendance.mapper.SettlementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SettlementService {

    private final SettlementMapper settlementMapper;

    @Transactional(readOnly = true)
    public List<SettlementResponse> findAll(SettlementFindRequest settlementFindRequest){
        return settlementMapper.findAll(settlementFindRequest);
    }

    public void update(SettlementUpdateRequest settlementUpdateRequest){
        settlementMapper.updateSettlement(settlementUpdateRequest);
    }




}
