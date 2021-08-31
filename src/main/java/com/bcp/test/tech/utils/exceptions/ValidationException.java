package com.bcp.test.tech.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends FriendlyException {

    public ValidationException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
