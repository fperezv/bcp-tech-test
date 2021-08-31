package com.bcp.test.tech.service.internal;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper.ExchangeModelMapper;
import com.bcp.test.tech.infrastructure.persistence.h2.repositories.ExchangeRepository;
import com.bcp.test.tech.service.ExchangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultExchangeService implements ExchangeService {

    private ExchangeRepository exchangeRepository;
    private ExchangeModelMapper exchangeModelMapper;

    @Override
    public ExchangeModel register(ExchangeModel exchange) {
        log.info("[register] init. [exchange={}]", exchange);
        var exchangeToRegister = exchangeModelMapper.mapIn(exchange);
        exchangeToRegister.setAmountExchanged(
                exchange.getChange().getIn() ?
                        exchange.getAmount().multiply(exchange.getChange().getAmount()) :
                        exchange.getAmount().divide(exchange.getChange().getAmount(), RoundingMode.FLOOR)
        );
        var registeredExchange = exchangeRepository.save(exchangeToRegister);
        log.info("[register] end. [exchange={}]", registeredExchange);
        return exchangeModelMapper.mapOut(registeredExchange);
    }

}
