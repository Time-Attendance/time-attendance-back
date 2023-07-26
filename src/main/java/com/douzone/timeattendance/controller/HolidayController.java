package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.holiday.HolidayCreateRequest;
import com.douzone.timeattendance.dto.holiday.HolidayResponse;
import com.douzone.timeattendance.service.HolidayService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/{holidayId}")
    public HolidayResponse findById(@PathVariable Long holidayId) {
        return holidayService.findHolidayById(holidayId);
    }

    @GetMapping
    public List<HolidayResponse> findAll() {
        return holidayService.findAllHolidays();
    }

    @PostMapping
    public void create(@RequestBody @Valid HolidayCreateRequest holidayCreateRequest) {
        holidayService.createHoliday(holidayCreateRequest);
    }

    @DeleteMapping("{holidayId}")
    public void delete(@PathVariable Long holidayId) {
        holidayService.deleteHoliday(holidayId);
    }
}
