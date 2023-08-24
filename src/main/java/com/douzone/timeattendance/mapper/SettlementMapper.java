package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.dto.settlement.SettlementFindRequest;
import com.douzone.timeattendance.dto.settlement.SettlementResponse;
import com.douzone.timeattendance.dto.settlement.SettlementUpdateRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettlementMapper {

    List<SettlementResponse> findAll(SettlementFindRequest settlementFindRequest);

    void updateSettlement(SettlementUpdateRequest settlementUpdateRequest);
    void insertSettlement(Settlement settlement);
}
