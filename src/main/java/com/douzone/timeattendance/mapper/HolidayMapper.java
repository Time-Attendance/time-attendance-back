package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Holiday;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HolidayMapper {

    Optional<Holiday> findById(Long id);

    List<Holiday> findAll();

    void insert(Holiday holiday);

    void delete(Long holidayId);

    boolean existsDate(LocalDate date);
}
