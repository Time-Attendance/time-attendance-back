package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.company.CompanyCodeUpdateResponse;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.dto.company.CompanyUpdateDto;
import com.douzone.timeattendance.exception.company.NoSuchCompanyException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyFacade {

    private final CompanyService companyService;
    private final WorkGroupService workGroupService;
    private final WorkDayTypeService workDayTypeService;
    private final TimeRangeService timeRangeService;

    @Transactional(readOnly = true)
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    public void createCompany(MultipartFile file, CompanyCreateRequest companyCreateRequest) {
        Company company = companyService.createCompany(file, companyCreateRequest);
        WorkGroup workGroup = workGroupService.insertWorkGroup(createDefaultWorkGroup(company.getCompanyId()));
        workDayTypeService.insertWorkDayType(createDefaultWorkDayType(workGroup.getWorkGroupId()));
        for (TimeRange timeRange : createDefaultTimeRangeList(workGroup.getWorkGroupId())) {
            timeRangeService.insertTimeRange(timeRange);
        }
    }

    public CompanyCodeUpdateResponse updateCompanyCode(Long companyId) {
        companyService.findByCompanyId(companyId)
                      .orElseThrow(NoSuchCompanyException::new);

        String code = UUID.randomUUID().toString();
        CompanyUpdateDto updateParam = CompanyUpdateDto.builder()
                                                       .code(code)
                                                       .build();
        companyService.update(companyId, updateParam);

        //TODO: 정적 팩토리 메서드로 통일
        return new CompanyCodeUpdateResponse(code);
    }

    private WorkGroup createDefaultWorkGroup(Long companyId) {
        WorkGroup workGroup = new WorkGroup();
        workGroup.setName("일반근로제A");
        workGroup.setType("일반");
        workGroup.setCompanyId(companyId);
        workGroup.setDateCreated(LocalDateTime.now());
        workGroup.setDateUpdated(LocalDateTime.now());
        workGroup.setIsDeleted(false);
        workGroup.setIsOn(true);
        return workGroup;
    }

    private WorkDayType createDefaultWorkDayType(Long workGroupId) {
        WorkDayType workDayType = new WorkDayType();
        workDayType.setWorkGroupId(workGroupId);
        workDayType.setMon("근무");
        workDayType.setThu("근무");
        workDayType.setWed("근무");
        workDayType.setTue("근무");
        workDayType.setFri("근무");
        workDayType.setSat("무급");
        workDayType.setSun("유급");
        return workDayType;
    }

    private List<TimeRange> createDefaultTimeRangeList(Long workGroupId) {
        List<TimeRange> timeRangeList = new ArrayList<>();
        timeRangeList.add(
                createDefaultTimeRange("근무", LocalTime.parse("09:00:00"), LocalTime.parse("18:00:00"), workGroupId));
        timeRangeList.add(
                createDefaultTimeRange("휴게", LocalTime.parse("12:00:00"), LocalTime.parse("13:00:00"), workGroupId));
        timeRangeList.add(
                createDefaultTimeRange("의무", LocalTime.parse("09:00:00"), LocalTime.parse("12:00:00"), workGroupId));
        timeRangeList.add(
                createDefaultTimeRange("승인", LocalTime.parse("18:00:00"), LocalTime.parse("23:59:59"), workGroupId));
        return timeRangeList;
    }

    private TimeRange createDefaultTimeRange(String type, LocalTime start, LocalTime end, Long workGroupId) {
        TimeRange timeRange = new TimeRange();
        timeRange.setType(type);
        timeRange.setStart(start);
        timeRange.setEnd(end);
        timeRange.setWorkGroupId(workGroupId);
        return timeRange;
    }
}
