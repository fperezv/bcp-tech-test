package com.bcp.test.tech.infrastructure.persistence.h2.entities.mapper;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.infrastructure.persistence.h2.entities.ChangeEntity;
import com.bcp.test.tech.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ChangeModelMapper extends ModelMapper<ChangeModel, ChangeEntity> {

    private CoinModelMapper coinModelMapper;

    @Override
    public ChangeEntity mapIn(ChangeModel input) {
        return ChangeEntity.builder()
                .id(input.getId())
                .originCoin(input.getOriginCoin() == null ? null : coinModelMapper.mapIn(input.getOriginCoin()))
                .destinationCoin(input.getDestinationCoin() == null ? null : coinModelMapper.mapIn(input.getDestinationCoin()))
                .in(input.getIn())
                .date(DateUtils.fromLong(input.getLongDate()))
                .amount(input.getAmount())
                .build();
    }

    @Override
    public ChangeModel mapOut(ChangeEntity output) {
        return ChangeModel.builder()
                .id(output.getId())
                .originCoin(output.getOriginCoin() == null ? null : coinModelMapper.mapOut(output.getOriginCoin()))
                .destinationCoin(output.getDestinationCoin() == null ? null : coinModelMapper.mapOut(output.getDestinationCoin()))
                .in(output.getIn())
                .longDate(output.getDate().getTime())
                .date(DateUtils.format(output.getDate()))
                .amount(output.getAmount())
                .build();
    }

}
