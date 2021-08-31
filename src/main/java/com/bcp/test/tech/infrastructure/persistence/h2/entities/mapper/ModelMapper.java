package com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ModelMapper<T, K> {

    public abstract K mapIn(T input);

    public abstract T mapOut(K output);

    public List<K> mapIn(List<T> input) {
        return input.stream().map(this::mapIn).collect(Collectors.toList());
    }

    public List<T> mapOut(List<K> output) {
        return output.stream().map(this::mapOut).collect(Collectors.toList());
    }

}
