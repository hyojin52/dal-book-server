package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OfferingCreateRequest {
    private LocalDate date;
    private String type;
    private String churchMemberId;
    private int amount;
    private String memo;
}
