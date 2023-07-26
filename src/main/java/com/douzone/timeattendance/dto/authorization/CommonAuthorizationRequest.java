package com.douzone.timeattendance.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class CommonAuthorizationRequest {

    private List<Long> userIds;
}
