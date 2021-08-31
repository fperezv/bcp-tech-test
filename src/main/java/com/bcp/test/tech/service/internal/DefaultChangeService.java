package com.bcp.test.tech.service.internal;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.ChangeEntity;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper.ChangeModelMapper;
import com.bcp.test.tech.infrastructure.persistence.h2.repositories.ChangeRepository;
import com.bcp.test.tech.service.ChangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultChangeService implements ChangeService {

    private ChangeRepository changeRepository;
    private ChangeModelMapper changeModelMapper;

    @Override
    public Optional<ChangeModel> findCurrent(Long originCoinId, Long destinationCoinId) {
        log.info("[findCurrent] init.");

        var inOptional = changeRepository.findFirstByOriginCoinIdAndDestinationCoinIdOrderByDateDesc(
                originCoinId, destinationCoinId
        );
        var outOptional = changeRepository.findFirstByOriginCoinIdAndDestinationCoinIdOrderByDateDesc(
                destinationCoinId, originCoinId
        );

        Optional<ChangeEntity> finalOptional = Optional.empty();
        if (inOptional.isPresent() && outOptional.isPresent()) {
            finalOptional = Stream.of(inOptional.get(), outOptional.get()).max(Comparator.comparing(ChangeEntity::getDate));
        } else if (inOptional.isPresent()) {
            finalOptional = inOptional;
        } else if (outOptional.isPresent()) {
            finalOptional = outOptional;
        }

        log.info("[findCurrent] end. [change={}]", inOptional);
        return finalOptional.map(changeEntity -> changeModelMapper.mapOut(changeEntity));
    }

    @Override
    public Optional<ChangeModel> findById(Long id) {
        log.info("[findById] init. [id={}", id);
        var optional = changeRepository.findById(id);
        log.info("[findById] end. [change={}]", optional);
        return optional.map(changeEntity -> changeModelMapper.mapOut(changeEntity));
    }

    @Override
    public ChangeModel register(ChangeModel change) {
        log.info("[register] init. [change={}]", change);
        var registeredChange = changeRepository.save(changeModelMapper.mapIn(change));
        log.info("[register] end. [change={}]", registeredChange);
        return changeModelMapper.mapOut(registeredChange);
    }

}
