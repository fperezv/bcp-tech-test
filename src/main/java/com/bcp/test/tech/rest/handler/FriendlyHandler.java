package com.bcp.test.tech.rest.handler;

import com.bcp.test.tech.domain.rr.response.ErrorResponse;
import com.bcp.test.tech.utils.exceptions.FriendlyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class FriendlyHandler {

    @ExceptionHandler(FriendlyException.class)
    public ResponseEntity<ErrorResponse> handleFriendlyException(FriendlyException exception) {
        log.error("Handling friendly exception. [exception={}]", exception.getMessage(), exception);
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .key(exception.getKey())
                        .message(exception.getMessage())
                        .build(),
                exception.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("Handling any exception. [exception={}]", exception.getMessage(), exception);
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .key("unexpected")
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
