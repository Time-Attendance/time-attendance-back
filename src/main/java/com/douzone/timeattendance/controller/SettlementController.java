package com.douzone.timeattendance.controller;


import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.settlement.SettlementFindRequest;
import com.douzone.timeattendance.dto.settlement.SettlementReplayRequest;
import com.douzone.timeattendance.dto.settlement.SettlementResponse;
import com.douzone.timeattendance.dto.settlement.SettlementUpdateRequest;
import com.douzone.timeattendance.global.auth.LoginUser;
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
    public ResponseEntity<List<SettlementResponse>> findAll(@LoginUser AuthInfo authInfo, @ModelAttribute @Valid SettlementFindRequest settlementFindRequest) {
        return ResponseEntity.ok().body(settlementService.findAll(settlementFindRequest));
    }

    @PatchMapping
    public ResponseEntity<Void> updateSettlement(@LoginUser AuthInfo authInfo, @RequestBody SettlementUpdateRequest settlementUpdateRequest) {
        settlementService.update(settlementUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> reSettlement(@RequestBody SettlementReplayRequest settlementReplayRequest) {
        settlementService.reSettlement(settlementReplayRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{settlementId}")
    public ResponseEntity<Void> deleteSettlement(@LoginUser AuthInfo authInfo, @PathVariable Long settlementId) {
        settlementService.deleteSettlement(settlementId);
        return ResponseEntity.ok().build();
    }
}
