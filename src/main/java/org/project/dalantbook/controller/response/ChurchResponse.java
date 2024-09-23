package org.project.dalantbook.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.project.dalantbook.domain.ChurchEntity;

@Builder
@Data
@AllArgsConstructor
public class ChurchResponse {
    private String churchId;
    private String name;
    private String pastor;
    private String denomination;
    private String address;
    private String phone;

    public static ChurchResponse of(ChurchEntity entity) {
        return ChurchResponse.builder()
                .churchId(entity.getId())
                .name(entity.getName())
                .pastor(entity.getPastor())
                .denomination(entity.getDenomination())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .build();
    }

}
