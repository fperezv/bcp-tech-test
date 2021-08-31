package com.bcp.test.tech.service;

import com.bcp.test.tech.domain.models.CoinModel;

import java.util.Optional;

public interface CoinService {

    Optional<CoinModel> findByShortName(String shortName);

}
