package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.dto.company.CompanyCodeUpdateResponse;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.dto.company.CompanyUpdateDto;
import com.douzone.timeattendance.dto.company.CompanyUpdateRequest;
import com.douzone.timeattendance.exception.company.NoSuchCompanyException;
import com.douzone.timeattendance.global.util.FileUtil;
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

    @Transactional(readOnly = true)
    public CompanyResponse findByCompanyId(Long companyId) {
        return companyService.findByCompanyId(companyId)
                             .map(CompanyResponse::new)
                             .orElseThrow(NoSuchCompanyException::new);
    }

    public void createCompany(MultipartFile file, CompanyCreateRequest companyCreateRequest) {
        //회사 생성
        Company company = companyService.createCompany(file, companyCreateRequest);

        //기본 근로그룹 생성
        WorkGroup defaultWorkGroup = createDefaultWorkGroup(company.getCompanyId());
        workGroupService.insertWorkGroup(defaultWorkGroup);

        WorkDayType defaultWorkDayType = createDefaultWorkDayType(defaultWorkGroup.getWorkGroupId());
        List<TimeRange> defaultTimeRangeList = createDefaultTimeRangeList(defaultWorkGroup.getWorkGroupId());

        workDayTypeService.insertWorkDayType(defaultWorkDayType);
        for (TimeRange timeRange : defaultTimeRangeList) {
            timeRangeService.insertTimeRange(timeRange);
        }

        //근로제 이력 테이블 insert
        companyService.insertWorkGroupRecord(defaultWorkGroup, defaultTimeRangeList, defaultWorkDayType);
    }

    public CompanyCodeUpdateResponse updateCompanyCode(Long companyId) {
        Company company = companyService.findByCompanyId(companyId)
                                        .orElseThrow(NoSuchCompanyException::new);

        String code = UUID.randomUUID().toString();
        CompanyUpdateDto updateParam = CompanyUpdateDto.builder()
                                                       .code(code)
                                                       .logoUrl(company.getLogoUrl())
                                                       .build();
        companyService.update(companyId, updateParam);

        //TODO: 정적 팩토리 메서드로 통일
        return new CompanyCodeUpdateResponse(code);
    }

    public void updateCompany(Long companyId, CompanyUpdateRequest companyUpdateRequest) {
        //수정할 회사가 존재하는지 검증
        Company company = companyService.findByCompanyId(companyId)
                                        .orElseThrow(NoSuchCompanyException::new);

        //수정할 회사 이름 중복 검증
        if(!company.getName().equals(companyUpdateRequest.getName())) {
            companyService.validateCompanyName(companyUpdateRequest.getName());
        }

        CompanyUpdateDto updateParam = new CompanyUpdateDto();
        updateParam.setName(companyUpdateRequest.getName());

        switch (companyUpdateRequest.getImageAction()) {
            case DELETE:
                //이미지 파일 삭제 및 DB 업데이트
                FileUtil.removeFile(company.getLogoUrl());
                updateParam.setLogoUrl(null);
                break;

            case KEEP:
                //기존 로고 파일 적용
                updateParam.setLogoUrl(company.getLogoUrl());
                break;

            case UPDATE:
                //기존 이미지 파일 삭제
                FileUtil.removeFile(company.getLogoUrl());

                //새 이미지 파일 저장 및 DB 업데이트
                String storeFilename = FileUtil.saveFile(companyUpdateRequest.getFile());
                updateParam.setLogoUrl(storeFilename);
                break;
        }

        companyService.update(companyId, updateParam);
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
                createDefaultTimeRange("승인", LocalTime.parse("18:00:00"), LocalTime.parse("00:00:00"), workGroupId));
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
