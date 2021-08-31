package com.bcp.test.tech.rest;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.domain.rr.request.ChangeRequest;
import com.bcp.test.tech.rest.facade.ChangeFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Single;
import rx.schedulers.Schedulers;

import java.net.URI;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api-change")
public class ChangeController {

    private ChangeFacade changeFacade;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<ChangeModel>> findById(
            @PathVariable Long id
    ) {
        log.info("[findById] init. [id={}]", id);
        return changeFacade.findById(id)
                .subscribeOn(Schedulers.io())
                .map(ResponseEntity::ok);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<ChangeModel>> register(
            @RequestBody ChangeRequest request
    ) {
        log.info("[register] init. [request={}]", request);
        return changeFacade.register(request)
                .subscribeOn(Schedulers.io())
                .map(r -> ResponseEntity.created(URI.create("/api-change/" + r.getId())).body(r));
    }

}
