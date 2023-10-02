package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.domain.TimeRange;
import com.douzone.timeattendance.domain.WorkDayType;
import com.douzone.timeattendance.domain.WorkGroup;
import com.douzone.timeattendance.domain.WorkGroupRecord;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.dto.company.CompanyUpdateDto;
import com.douzone.timeattendance.exception.company.AlreadyExistsCompanyNameException;
import com.douzone.timeattendance.global.util.FileUtil;
import com.douzone.timeattendance.mapper.CompanyMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyMapper companyMapper;

    public Company createCompany(MultipartFile file, CompanyCreateRequest companyCreateRequest) {
        //회사 이름 중복 검증
        validateCompanyName(companyCreateRequest.getName());

        //파일저장
        String storeFilename = FileUtil.saveFile(file);

        //새 회사 생성
        Company company = new Company(
                companyCreateRequest.getName(),
                UUID.randomUUID().toString(),
                storeFilename);

        companyMapper.insert(company);

        return company;
    }

    //회사 기본 근로제를 근로제 이력 테이블에 추가
    public void insertWorkGroupRecord(WorkGroup workGroup, List<TimeRange> timeRangeList, WorkDayType workDayType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Map<String, String> formattedTimeInfo = formatTimeInfo(timeRangeList, formatter);

        WorkGroupRecord workGroupRecord = WorkGroupRecord.builder()
                                                         .date(LocalDateTime.now())
                                                         .workGroupName(workGroup.getName())
                                                         .workGroupType(workGroup.getType())
                                                         .timeRangeType(formattedTimeInfo.get("timeRangeType"))
                                                         .start(formattedTimeInfo.get("start"))
                                                         .end(formattedTimeInfo.get("end"))
                                                         .mon(workDayType.getMon())
                                                         .tue(workDayType.getTue())
                                                         .wed(workDayType.getWed())
                                                         .thu(workDayType.getThu())
                                                         .fri(workDayType.getFri())
                                                         .sat(workDayType.getSat())
                                                         .sun(workDayType.getSun())
                                                         .workGroupId(workGroup.getWorkGroupId())
                                                         .build();

        companyMapper.insertWorkGroupRecord(workGroupRecord);
    }

    public void update(Long companyId, CompanyUpdateDto updateParam) {
        companyMapper.update(companyId, updateParam);
    }

    @Transactional(readOnly = true)
    public List<CompanyResponse> findAll() {
        return companyMapper.findAll()
                            .stream()
                            .map(CompanyResponse::new)
                            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Company> findByCompanyId(Long companyId) {
        return companyMapper.findByCompanyId(companyId);
    }

    @Transactional(readOnly = true)
    public void validateCompanyName(String name) {
        if (companyMapper.existsName(name)) {
            throw new AlreadyExistsCompanyNameException();
        }
    }

    //시간범위 데이터를 근로제 이력 테이블의 포맷으로 변환
    private Map<String, String> formatTimeInfo(List<TimeRange> timeRangeList, DateTimeFormatter formatter) {
        StringBuilder timeRangeTypeBuilder = new StringBuilder();
        StringBuilder startBuilder = new StringBuilder();
        StringBuilder endBuilder = new StringBuilder();

        for (TimeRange timeRange : timeRangeList) {
            if (timeRangeTypeBuilder.length() > 0) {
                timeRangeTypeBuilder.append(", ");
                startBuilder.append(", ");
                endBuilder.append(", ");
            }
            timeRangeTypeBuilder.append(timeRange.getType());
            startBuilder.append(timeRange.getStart().format(formatter));
            endBuilder.append(timeRange.getEnd().format(formatter));
        }

        Map<String, String> result = new HashMap<>();
        result.put("timeRangeType", timeRangeTypeBuilder.toString());
        result.put("start", startBuilder.toString());
        result.put("end", endBuilder.toString());

        return result;
    }
}
