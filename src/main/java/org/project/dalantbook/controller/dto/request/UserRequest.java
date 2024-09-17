package org.project.dalantbook.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.dalantbook.domain.enums.UserPosition;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userName;
    private String password;
    private Long groupId;
    private String mobileNumber;
    private String birthdate;
    private UserPosition position;
}
