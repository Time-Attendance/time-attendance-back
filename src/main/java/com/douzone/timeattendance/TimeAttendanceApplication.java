package com.douzone.timeattendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimeAttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeAttendanceApplication.class, args);
	}

}
