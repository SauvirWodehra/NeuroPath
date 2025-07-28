package com.sauvir.NeuroPath.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongId extends RuntimeException {
    public WrongId(String message) {
        super(message);
    }
}
