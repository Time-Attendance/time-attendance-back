package com.douzone.timeattendance;

import com.douzone.timeattendance.service.SettlementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootTest
class TimeAttendanceApplicationTests {

	@Autowired
	private SettlementService settlementService;

	@Test
	void contextLoads() {
		settlementService.settlementSchedule();
	}

}
