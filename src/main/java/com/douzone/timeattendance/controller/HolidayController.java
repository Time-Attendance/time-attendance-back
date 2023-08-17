package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.holiday.HolidayCreateRequest;
import com.douzone.timeattendance.dto.holiday.HolidayResponse;
import com.douzone.timeattendance.service.HolidayService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/{holidayId}")
    public ResponseEntity<HolidayResponse> findById(@PathVariable Long holidayId) {
        return ResponseEntity.ok()
                             .body(holidayService.findHolidayById(holidayId));
    }

    @GetMapping
    public ResponseEntity<List<HolidayResponse>> findAll() {
        return ResponseEntity.ok()
                             .body(holidayService.findAllHolidays());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid HolidayCreateRequest holidayCreateRequest) {
        holidayService.createHoliday(holidayCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    @DeleteMapping("{holidayId}")
    public ResponseEntity<Void> delete(@PathVariable Long holidayId) {
        holidayService.deleteHoliday(holidayId);
        return ResponseEntity.noContent()
                             .build();
    }
}
