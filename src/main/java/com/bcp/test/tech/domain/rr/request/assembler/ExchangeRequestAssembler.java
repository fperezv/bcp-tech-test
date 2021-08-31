package com.bcp.test.tech.domain.rr.request.assembler;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.domain.rr.request.ExchangeRequest;
import com.bcp.test.tech.utils.CheckerUtils;

public final class ExchangeRequestAssembler {

    public static ExchangeModel toModel(final ExchangeRequest request) {
        CheckerUtils.notEmpty(request.getAmount(), "monto");
        CheckerUtils.notEmpty(request.getOriginCoin(), "monedaOrigen");
        CheckerUtils.notEmpty(request.getDestinationCoin(), "monedaDestino");
        return ExchangeModel.builder()
                .amount(request.getAmount())
                .originCoinName(request.getOriginCoin())
                .destinationCoinName(request.getDestinationCoin())
                .build();
    }

}
