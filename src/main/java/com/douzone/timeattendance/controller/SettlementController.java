package com.douzone.timeattendance.controller;


import com.douzone.timeattendance.dto.settlement.SettlementFindRequest;
import com.douzone.timeattendance.dto.settlement.SettlementReplayRequest;
import com.douzone.timeattendance.dto.settlement.SettlementResponse;
import com.douzone.timeattendance.dto.settlement.SettlementUpdateRequest;
import com.douzone.timeattendance.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/settlements")
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementService settlementService;

    @GetMapping
    public ResponseEntity<List<SettlementResponse>> findAll(@ModelAttribute @Valid SettlementFindRequest settlementFindRequest) {
        return ResponseEntity.ok().body(settlementService.findAll(settlementFindRequest));
    }

    @PatchMapping
    public ResponseEntity<Void> updateSettlement(@RequestBody SettlementUpdateRequest settlementUpdateRequest){
        settlementService.update(settlementUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> reSettlement(@RequestBody SettlementReplayRequest settlementReplayRequest){
        settlementService.reSettlement(settlementReplayRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSettlement(@RequestBody List<Long> settlementIds){
        settlementService.delete(settlementIds);
        return ResponseEntity.ok().build();
    }
}
