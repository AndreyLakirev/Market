package org.sber.lakirev.market.util;

import org.sber.lakirev.market.exception.NotFoundException;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static <T> T checkNotFound(T object, Class<T> clazz) {
        if (object == null) {
            throw new NotFoundException(String.format("%s not found", clazz.getCanonicalName()));
        } else {
            return object;
        }
    }
}