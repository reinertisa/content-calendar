package com.reinertisa.contentcalendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    private Integer id;

    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound(String message, Integer id) {
        super(message + " " + id);
    }

    public Integer getId() {
        return id;
    }
}
