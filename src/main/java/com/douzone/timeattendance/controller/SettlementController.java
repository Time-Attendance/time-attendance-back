package com.douzone.timeattendance.controller;


import com.douzone.timeattendance.dto.settlement.SettlementFindRequest;
import com.douzone.timeattendance.dto.settlement.SettlementResponse;
import com.douzone.timeattendance.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/settlements")
public class SettlementController {

    private final SettlementService settlementService;

    @Autowired
    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @GetMapping
    public ResponseEntity<List<SettlementResponse>> findAll(@ModelAttribute @Valid SettlementFindRequest settlementFindRequest) {
        return ResponseEntity.ok().body(settlementService.findAll(settlementFindRequest));
    }
}
