package org.project.dalantbook.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND_CHURCH_MEMBER(HttpStatus.NOT_FOUND, "Church member not found"),
    NOT_FOUND_CHURCH(HttpStatus.NOT_FOUND, "Church not found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error")
    ;

    private HttpStatus status;
    private String message;
}
