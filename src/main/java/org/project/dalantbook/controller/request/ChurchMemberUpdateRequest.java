package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChurchMemberUpdateRequest {
    private String name;
    private String memo;
}
