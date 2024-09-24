package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OfferingUpdateRequest {
    private LocalDate date;
    private String type;
    private int amount;
    private String memo;
}
