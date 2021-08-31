package com.bcp.test.tech.utils;

import java.util.Date;

public final class FunctionUtils {

    public static <T> T iif(T valueToCheck, T ifNullValue) {
        return valueToCheck == null ? ifNullValue : valueToCheck;
    }

}
