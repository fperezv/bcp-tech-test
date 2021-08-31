package com.bcp.test.tech.service.internal;

import com.bcp.test.tech.domain.models.CoinModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper.CoinModelMapper;
import com.bcp.test.tech.infrastructure.persistence.h2.repositories.CoinRepository;
import com.bcp.test.tech.service.CoinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultCoinService implements CoinService {

    private CoinRepository coinRepository;
    private CoinModelMapper coinModelMapper;

    @Override
    public Optional<CoinModel> findByShortName(String shortName) {
        log.info("[findByShortName] init. [shortName={}]", shortName);
        var optional = coinRepository.findByShortName(shortName);
        log.info("[findByShortName] end. [coin={}]", optional);
        return optional.map(coinEntity -> coinModelMapper.mapOut(coinEntity));
    }

}
