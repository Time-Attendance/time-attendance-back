package com.douzone.timeattendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TimeRecord {

    private Long timeRecordId;      //PK
    private LocalDate date;
    private LocalDateTime startWork;
    private LocalDateTime leaveWork;
    private String workState; //WorkState enum 사용 고려
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;            //FK(관계 X)

    /**
     * 생성자 대신 빌더 패턴을 사용하면 객체를 유연하게 생성할 수 있습니다.
     * 추후 관리자가 지난 출퇴근 기록을 직접 생성할 수도 있으므로 빌더 패턴을 사용했습니다.
     */
    @Builder
    public TimeRecord(LocalDate date, LocalDateTime startWork, LocalDateTime leaveWork, String workState, Long userId) {
        this.date = date;
        this.startWork = startWork;
        this.leaveWork = leaveWork;
        this.workState = workState;
        this.userId = userId;
    }
}
