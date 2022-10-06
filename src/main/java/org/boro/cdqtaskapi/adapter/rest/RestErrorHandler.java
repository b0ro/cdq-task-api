package org.boro.cdqtaskapi.adapter.rest;

import lombok.Value;
import org.boro.cdqtaskapi.domain.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
class RestErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    ErrorResponse handleNotFound(TaskNotFoundException exception) {
        return ErrorResponse.of(
            Instant.now(),
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage()
        );
    }

    @Value(staticConstructor = "of")
    static class ErrorResponse {

        Instant timestamp;

        Integer status;

        String error;
    }
}
