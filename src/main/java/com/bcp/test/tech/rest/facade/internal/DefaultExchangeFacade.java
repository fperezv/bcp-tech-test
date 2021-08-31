package com.bcp.test.tech.rest.facade.internal;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.domain.rr.request.ExchangeRequest;
import com.bcp.test.tech.domain.rr.request.assembler.ExchangeRequestAssembler;
import com.bcp.test.tech.rest.facade.ExchangeFacade;
import com.bcp.test.tech.service.ChangeService;
import com.bcp.test.tech.service.CoinService;
import com.bcp.test.tech.service.ExchangeService;
import com.bcp.test.tech.utils.exceptions.FriendlyException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rx.Single;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultExchangeFacade implements ExchangeFacade {

    private ExchangeService exchangeService;
    private ChangeService changeService;
    private CoinService coinService;

    @Override
    public Single<ExchangeModel> exchange(ExchangeRequest request) {
        log.info("[exchange] init. [request={}]", request);

        return Single.create(subscriber -> {
            var originCoin = coinService.findByShortName(request.getOriginCoin());
            var destinationCoin = coinService.findByShortName(request.getDestinationCoin());
            if (originCoin.isEmpty()) {
                subscriber.onError(new FriendlyException("No se ha encontrado la moneda origen especificada."));
            } else if (destinationCoin.isEmpty()) {
                subscriber.onError(new FriendlyException("No se ha encontrado la moneda destino especificada."));
            } else {
                var currentChange = changeService.findCurrent(originCoin.get().getId(), destinationCoin.get().getId());
                log.debug("[exchange] change found. [change={}]", currentChange);
                if (currentChange.isEmpty()) {
                    subscriber.onError(new FriendlyException("No existe un tipo de cambio registrado."));
                } else {
                    var exchange = exchangeService.register(
                            ExchangeRequestAssembler.toModel(request)
                                    .setExchangeAmount(currentChange.get().getAmount())
                                    .setOriginCoin(originCoin.get())
                                    .setDestinationCoin(destinationCoin.get())
                                    .setChange(currentChange.get())
                    );
                    log.info("[exchange] end. [exchange={}]", exchange);
                    subscriber.onSuccess(exchange);
                }
            }
        });
    }

}
