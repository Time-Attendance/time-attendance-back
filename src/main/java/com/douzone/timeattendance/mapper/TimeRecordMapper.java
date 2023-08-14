package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.TimeRecord;
import com.douzone.timeattendance.dto.timerecord.TimeRecordUpdateDto;
import java.time.LocalDate;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimeRecordMapper {

    void insert(TimeRecord timeRecord);

    void update(TimeRecordUpdateDto updateParam);

    Optional<TimeRecord> findByDate(@Param("userId") Long userId, @Param("date") LocalDate date);

    boolean existsByUserIdAndDate(Long userId, LocalDate date);
}
