package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.dto.timerecord.TimeRecordUpdateDto;
import com.douzone.timeattendance.dto.timerecord.TimeRecordSettlementResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimeRecordMapper {

    void insert(TimeRecord timeRecord);

    void update(TimeRecordUpdateDto updateParam);

    Optional<TimeRecord> findByDate(@Param("userId") Long userId, @Param("date") LocalDate date);

    List<TimeRecordSettlementResponse> findTimeRecordByUserIdBetweenStartDateAndEndDate(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    boolean existsByUserIdAndDate(Long userId, LocalDate date);
}
