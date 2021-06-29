package org.sber.lakirev.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Json value")
public class JsonBodyException extends RuntimeException {
    public JsonBodyException(String message) {
        super(message);
    }
}
