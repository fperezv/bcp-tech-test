package com.bcp.test.tech.utils;

import com.bcp.test.tech.utils.exceptions.ValidationException;
import org.springframework.util.ObjectUtils;

public final class CheckerUtils {

    public static void notEmpty(final Object attribute, final String attributeName) {
        if (ObjectUtils.isEmpty(attribute)) {
            throw new ValidationException(String.format("[%s] must not be null or empty.", attributeName));
        }
    }

    public static void mustBeTrue(final boolean checker, final String message) {
        if (!checker) {
            throw new ValidationException(message);
        }
    }

    public static void mustByFalse(final boolean checker, final String message) {
        if (checker) {
            throw new ValidationException(message);
        }
    }

}
