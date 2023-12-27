package com.silvercsoft.test.mybookstoreapi.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private int status;
    private ZonedDateTime timestamp = ZonedDateTime.now();
    private List<String> errors = new ArrayList<>();

    public ExceptionResponse(int status) {
        this.status = status;
    }

    public ExceptionResponse addError(String error) {
        this.errors.add(error);
        return this;
    }
}
