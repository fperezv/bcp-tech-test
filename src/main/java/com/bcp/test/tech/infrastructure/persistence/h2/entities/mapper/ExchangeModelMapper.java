package com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.ExchangeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ExchangeModelMapper extends ModelMapper<ExchangeModel, ExchangeEntity> {

    private CoinModelMapper coinModelMapper;
    private ChangeModelMapper changeModelMapper;

    @Override
    public ExchangeEntity mapIn(ExchangeModel input) {
        return ExchangeEntity.builder()
                .id(input.getId())
                .originCoin(input.getOriginCoin() == null ? null : coinModelMapper.mapIn(input.getOriginCoin()))
                .destinationCoin(input.getDestinationCoin() == null ? null : coinModelMapper.mapIn(input.getDestinationCoin()))
                .amount(input.getAmount())
                .amountExchanged(input.getAmountExchanged())
                .changeApplied(input.getChange() == null ? null : changeModelMapper.mapIn(input.getChange()))
                .exchangeAmount(input.getExchangeAmount())
                .build();
    }

    @Override
    public ExchangeModel mapOut(ExchangeEntity output) {
        return ExchangeModel.builder()
                .id(output.getId())
                .amount(output.getAmount())
                .amountExchanged(output.getAmountExchanged())
                .exchangeAmount(output.getExchangeAmount())
                .originCoinName(output.getOriginCoin().getName())
                .destinationCoinName(output.getDestinationCoin().getName())
                .build();
    }

}
