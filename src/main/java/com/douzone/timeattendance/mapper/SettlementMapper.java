package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Settlement;
import com.douzone.timeattendance.dto.settlement.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SettlementMapper {

    List<SettlementResponse> findAll(SettlementFindRequest settlementFindRequest);

    void updateSettlement(SettlementUpdateRequest settlementUpdateRequest);
    void insertSettlement(Settlement settlement);

    void updateSettlementList(List<Settlement> settlements);    //근무, 유급일때 정산

    void deleteSettlementList(@Param("settlementIds") List<Long> settlementIds);    //무급일때 정산에서 삭제

    //회사와 근무그룹에 맞는 유저 목록들 조회
    List<SettlementFindCompanyDto> findCompanyAndWorkGroup(@Param("date")LocalDate date, @Param("searchParam") SettlementSearchDto settlementSearchDto);

    //회사, 근무그룹 찾기
    List<SettlementSearchDto> findCompanyIdAndWorkGroupIdList();
}
