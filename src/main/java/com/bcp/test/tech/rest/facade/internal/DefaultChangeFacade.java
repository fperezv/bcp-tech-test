package com.bcp.test.tech.rest.facade.internal;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.domain.rr.request.ChangeRequest;
import com.bcp.test.tech.domain.rr.request.assembler.ChangeRequestAssembler;
import com.bcp.test.tech.rest.facade.ChangeFacade;
import com.bcp.test.tech.service.ChangeService;
import com.bcp.test.tech.service.CoinService;
import com.bcp.test.tech.utils.exceptions.FriendlyException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import rx.Single;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultChangeFacade implements ChangeFacade {

    private ChangeService changeService;
    private CoinService coinService;

    @Override
    public Single<ChangeModel> findById(Long id) {
        log.info("[findById] init. [id={}]", id);
        return Single.create(subscriber -> {
            var changeOptional = changeService.findById(id);
            if (changeOptional.isPresent()) {
                var change = changeOptional.get();
                log.info("[findById] end. [change={}]", change);
                subscriber.onSuccess(change);
            } else {
                subscriber.onError(new FriendlyException(
                        HttpStatus.NO_CONTENT,
                        String.format("No se ha encontrado un tipo de cambio con identificador: %s", id)
                ));
            }
        });
    }

    @Override
    public Single<ChangeModel> register(ChangeRequest request) {
        log.info("[register] init. [request={}]", request);
        return Single.create(subscriber -> {
            var originCoin = coinService.findByShortName(request.getOriginCoin());
            var destinationCoin = coinService.findByShortName(request.getDestinationCoin());
            if (originCoin.isEmpty()) {
                subscriber.onError(new FriendlyException("No se ha encontrado la moneda origen especificada."));
            } else if (destinationCoin.isEmpty()) {
                subscriber.onError(new FriendlyException("No se ha encontrado la moneda destino especificada."));
            } else {
                var change = changeService.register(
                        ChangeRequestAssembler.toModel(request)
                                .setOriginCoin(originCoin.get())
                                .setDestinationCoin(destinationCoin.get())
                );
                subscriber.onSuccess(change);
            }
        });
    }

}
