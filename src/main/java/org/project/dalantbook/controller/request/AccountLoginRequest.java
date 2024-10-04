package org.project.dalantbook.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountLoginRequest {
    private String userId;
    private String password;
}
