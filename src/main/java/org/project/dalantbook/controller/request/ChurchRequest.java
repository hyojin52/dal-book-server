package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChurchRequest {
    private String name;
    private String pastor;
    private String denomination;
    private String address;
    private String phone;

}
