package com.douzone.timeattendance.global.util;

import java.util.Random;

public class UserUtil {
    private static final String[] DEPARTMENTS = {"영업", "개발", "인사", "회계", "기획"};

    /**
     * 랜덤 부서 생성
     */
    public static String getRandomDepartment() {
        Random random = new Random();
        int index = random.nextInt(DEPARTMENTS.length);
        return DEPARTMENTS[index];
    }
}
