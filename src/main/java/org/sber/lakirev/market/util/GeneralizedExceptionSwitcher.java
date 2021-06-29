package org.sber.lakirev.market.util;

import org.sber.lakirev.market.exception.JsonBodyException;
import org.sber.lakirev.market.exception.NoSuchIDException;
import org.sber.lakirev.market.exception.StorageException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.function.Supplier;

public class GeneralizedExceptionSwitcher {
    public static <T> T switchException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof InvalidDataAccessApiUsageException) {
                throw new JsonBodyException(e.getMessage());
            }
            if (e instanceof EmptyResultDataAccessException) {
                throw new NoSuchIDException(e.getMessage());
            }
            throw new StorageException(e);
        }
    }
}
