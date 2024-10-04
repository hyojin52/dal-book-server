package org.project.dalantbook.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    NOT_FOUND_CHURCH_MEMBER(HttpStatus.NOT_FOUND, "Church member not found"),
    NOT_FOUND_CHURCH(HttpStatus.NOT_FOUND, "Church not found"),
    NOT_FOUND_OFFERING(HttpStatus.NOT_FOUND, "Offering not found"),
    ACCOUNT_EXISTS(HttpStatus.BAD_REQUEST, "Account exist"),
    NOT_FOUND_ACCOUNT(HttpStatus.NOT_FOUND, "Account not found"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "Password is invalid"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED,  "Token is invalid"),
    ;

    private HttpStatus status;
    private String message;
}
