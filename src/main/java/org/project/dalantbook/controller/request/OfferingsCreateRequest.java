package org.project.dalantbook.controller.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class OfferingsCreateRequest {
    private String type;
    private LocalDate date;
    private List<UserInfo> userInfo;

    @Data
    public static class UserInfo {
        private String churchMemberId;
        private int amount;
        private String memo;
    }
}
