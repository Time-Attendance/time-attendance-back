package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import com.douzone.timeattendance.dto.workgroup.WorkGroupRequestDto;
import com.douzone.timeattendance.dto.workgrouprecord.WorkGroupRecordRequestDto;
import com.douzone.timeattendance.mapper.WorkGroupRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkGroupRecordService {

    private final WorkGroupRecordMapper workGroupRecordMapper;

    /**
     * 회원 id를 통해 회원이 소속된 근로제와 같은 근로제 id를 가지는 가장 최근 근로제 이력을 조회합니다.
     *
     * @param userId 조회할 회원 id
     * @return WorkGroupRecord
     */
    @Transactional(readOnly = true)
    public WorkGroupRecord findLatestWorkGroupRecordByUserId(Long userId) {
        return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(userId);
    }

    public String formatLocalTimesToString(LocalTime[] localTimes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < localTimes.length; i++) {
            String formattedTime = localTimes[i].format(formatter);
            result.append(formattedTime);

            // Append a comma after each element except the last one
            if (i < localTimes.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public void transferDayValues(WorkGroupRecordRequestDto target, WorkGroupRequestDto source) {
        WorkDayTypeRequestDto srcWorkDayType = source.getWorkDayType();

        target.setMon(srcWorkDayType.getMon());
        target.setTue(srcWorkDayType.getTue());
        target.setWed(srcWorkDayType.getWed());
        target.setThu(srcWorkDayType.getThu());
        target.setFri(srcWorkDayType.getFri());
        target.setSat(srcWorkDayType.getSat());
        target.setSun(srcWorkDayType.getSun());
    }

    public void saveWorkGroupRecord(WorkGroupRequestDto workGroupRequestDto, Long workGroupId) {
        WorkGroupRecordRequestDto workGroupRecordRequestDto = WorkGroupRecordRequestDto.builder()
                .date(LocalDateTime.now())
                .workGroupName(workGroupRequestDto.getName())
                .workGroupType(workGroupRequestDto.getType())
                .timeRangeType(String.join(", ", workGroupRequestDto.getTimeRangeType()))
                .build();

        workGroupRecordRequestDto.setStart(formatLocalTimesToString(workGroupRequestDto.getStart().toArray(new LocalTime[0])));
        workGroupRecordRequestDto.setEnd(formatLocalTimesToString(workGroupRequestDto.getEnd().toArray(new LocalTime[0])));
        transferDayValues(workGroupRecordRequestDto, workGroupRequestDto);
        workGroupRecordRequestDto.setWorkGroupId(workGroupId);

        workGroupRecordMapper.insertWorkGroupRecord(workGroupRecordRequestDto);
    }
}
