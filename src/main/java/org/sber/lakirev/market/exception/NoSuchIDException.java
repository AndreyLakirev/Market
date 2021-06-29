package org.sber.lakirev.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No item with selected ID was found")
public class NoSuchIDException extends RuntimeException {
    public NoSuchIDException(String message) {
        super(message);
    }
}
