package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChurchMemberCreateRequest {
    private String churchId;
    private String name;
    private String memo;
}
