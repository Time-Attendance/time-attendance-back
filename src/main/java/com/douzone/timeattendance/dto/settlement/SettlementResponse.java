package com.douzone.timeattendance.dto.settlement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
public class SettlementResponse {

    private Long settlementId;
    private LocalDate date;     //근무일자
    private Long userId;        //사원고유아이디
    private String userCode;    //사원번호
    private String name;        //이름(User)
    private String dept;        //부서(User)
    private String position;    //직급(User)
    private String workGroupType;   //근로제 타입(WorkGroupType) - ex) : 시차, 일반
    private LocalTime startTime;    //근무시작시간(인정시작시간)
    private LocalTime endTime;      //근무종료시간(인정종료시간)
    private LocalDateTime startWork;    //실제 출근 시간(TimeRecord)
    private LocalDateTime leaveWork;    //실제 퇴근 시간(TimeRecord)
    private String timeRangeType;       //시간 종류(WorkGroupRecord) - ex) 근무, 휴게, 의무, 승인
    private String start;               //근무 시작 시간(WorkGroupRecord)
    private String end;                 //근무 종료 시간(WorkGroupRecord)
    private LocalTime workingTime;  //소정근무시간
    private LocalTime overTime;     //초과근무시간
    private String workState;           //근무 상태(TimeRecord)
    private String dayType;             //근무,유급,무급
    private Long workGroupRecordId;     //근로제 이력 아이디


}
