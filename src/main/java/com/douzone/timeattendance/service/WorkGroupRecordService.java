package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.mapper.WorkGroupRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkGroupRecordService {

    private final WorkGroupRecordMapper workGroupRecordMapper;

    public WorkGroupRecord insert(WorkGroupRecord workGroupRecord) {
        workGroupRecordMapper.insert(workGroupRecord);
        return workGroupRecord;
    }

    /**
     * 회원 id를 통해 회원이 소속된 근로제와 같은 근로제 id를 가지는 가장 최근 근로제 이력을 조회합니다.
     * @param userId 조회할 회원 id
     * @return WorkGroupRecord
     */
    @Transactional(readOnly = true)
    public WorkGroupRecord findLatestWorkGroupRecordByUserId(Long userId) {
        return workGroupRecordMapper.findLatestWorkGroupRecordByUserId(userId);
    }
}
