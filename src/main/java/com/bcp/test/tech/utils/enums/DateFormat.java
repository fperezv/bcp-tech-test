package com.bcp.test.tech.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum DateFormat {

    DATE("dd/MM/yyyy"),
    TIME("HH:mm:ss"),
    TIMESTAMP("dd/MM/yyyy HH:mm:ss");

    private String value;

}
