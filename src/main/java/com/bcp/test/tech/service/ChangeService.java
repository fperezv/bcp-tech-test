package com.bcp.test.tech.service;

import com.bcp.test.tech.domain.models.ChangeModel;

import java.util.Optional;

public interface ChangeService {

    Optional<ChangeModel> findCurrent(final Long originCoinId, final Long destinationCoinId);

    Optional<ChangeModel> findById(final Long id);

    ChangeModel register(final ChangeModel change);

}
