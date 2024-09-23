package org.project.dalantbook.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.project.dalantbook.domain.ChurchMemberEntity;

@AllArgsConstructor
@Data
@Builder
public class ChurchMemberResponse {
    private String churchMemberId;
    private String churchId;
    private String name;
    private String memo;

    public static ChurchMemberResponse of(ChurchMemberEntity entity) {
        return ChurchMemberResponse.builder()
                .churchMemberId(entity.getId())
                .churchId(entity.getChurch().getId())
                .name(entity.getName())
                .memo(entity.getMemo())
                .build();
    }

}
