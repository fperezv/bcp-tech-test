package com.bcp.test.tech.rest;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.domain.rr.request.ExchangeRequest;
import com.bcp.test.tech.rest.facade.ExchangeFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Single;
import rx.schedulers.Schedulers;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api-exchange")
public class ExchangeController {

    private ExchangeFacade exchangeFacade;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<ExchangeModel>> exchange(
            @RequestBody ExchangeRequest request
    ) {
        log.info("[exchange] init. [request={}]", request);
        return exchangeFacade.exchange(request)
                .subscribeOn(Schedulers.io())
                .map(ResponseEntity::ok);
    }

}
