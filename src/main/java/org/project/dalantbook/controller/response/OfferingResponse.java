package org.project.dalantbook.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.project.dalantbook.domain.OfferingEntity;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class OfferingResponse {
    private String offeringId;
    private String churchMemberId;
    private String memo;
    private int amount;
    private String type;
    private LocalDate date;

    public static OfferingResponse of(OfferingEntity entity) {
        return OfferingResponse.builder()
                .offeringId(entity.getId())
                .churchMemberId(entity.getChurchMember().getId())
                .memo(entity.getMemo())
                .amount(entity.getAmount())
                .type(entity.getType())
                .date(LocalDate.from(entity.getDate()))
                .build();
    }
}
