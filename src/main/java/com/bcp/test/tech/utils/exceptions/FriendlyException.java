package com.bcp.test.tech.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FriendlyException extends RuntimeException {

    private final HttpStatus httpStatus;

    private String key;

    public FriendlyException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public FriendlyException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public FriendlyException(String key, String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.key = key;
    }

    public FriendlyException(HttpStatus httpStatus, String key, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.key = key;
    }

}
