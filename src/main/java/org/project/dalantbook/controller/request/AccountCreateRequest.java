package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountCreateRequest {
    private String userId;
    private String password;
    private String churchId;
}
