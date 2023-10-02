package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Holiday;
import com.douzone.timeattendance.dto.holiday.HolidayCreateRequest;
import com.douzone.timeattendance.dto.holiday.HolidayResponse;
import com.douzone.timeattendance.exception.holiday.AlreadyExistsDateException;
import com.douzone.timeattendance.exception.holiday.NoSuchHolidayException;
import com.douzone.timeattendance.mapper.HolidayMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 조회: findXXX, findXXXById, findAllXXX 생성: createXXX 수정: updateXXX 삭제: deleteXXX
 */
@Service
@RequiredArgsConstructor
@Transactional
public class HolidayService {

    private final HolidayMapper holidayMapper;

    @Transactional(readOnly = true)
    public HolidayResponse findHolidayById(Long holidayId) {
        return holidayMapper.findById(holidayId)
                            .map(HolidayResponse::new)
                            .orElseThrow(NoSuchHolidayException::new);
    }

    @Transactional(readOnly = true)
    public List<HolidayResponse> findAllHolidays() {
        return holidayMapper.findAll()
                            .stream()
                            .map(HolidayResponse::new)
                            .collect(Collectors.toList());
    }

    public void createHoliday(HolidayCreateRequest holidayCreateRequest) {
        validateDate(holidayCreateRequest.getDate());

        Holiday newHoliday = new Holiday(
            holidayCreateRequest.getDate(),
            holidayCreateRequest.getName(),
            holidayCreateRequest.getPayType());
        holidayMapper.insert(newHoliday);
    }

    public void deleteHoliday(Long holidayId) {
        //삭제 전 휴일 존재 여부 검증
        Holiday holiday = holidayMapper.findById(holidayId)
                                       .orElseThrow(NoSuchHolidayException::new);

        holidayMapper.delete(holiday.getHolidayId());
    }

    /**
     * 휴일 생성 시, 해당 날짜에 휴일이 존재하는 경우 예외를 발생시킵니다.
     */
    @Transactional(readOnly = true)
    public void validateDate(LocalDate date) {
        if (holidayMapper.existsDate(date)) {
            throw new AlreadyExistsDateException();
        }
    }
}
