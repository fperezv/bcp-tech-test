package com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper;

import com.bcp.test.tech.domain.models.CoinModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.CoinEntity;
import org.springframework.stereotype.Component;

@Component
public class CoinModelMapper extends ModelMapper<CoinModel, CoinEntity> {

    @Override
    public CoinEntity mapIn(CoinModel input) {
        return CoinEntity.builder()
                .id(input.getId())
                .shortName(input.getShortName())
                .name(input.getName())
                .symbol(input.getSymbol())
                .build();
    }

    @Override
    public CoinModel mapOut(CoinEntity output) {
        return CoinModel.builder()
                .id(output.getId())
                .shortName(output.getShortName())
                .name(output.getName())
                .symbol(output.getSymbol())
                .build();
    }

}
