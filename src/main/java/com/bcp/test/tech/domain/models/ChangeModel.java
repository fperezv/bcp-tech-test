package com.bcp.test.tech.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ChangeModel {

    private Long id;

    private CoinModel originCoin;

    private CoinModel destinationCoin;

    private Boolean in;

    private BigDecimal amount;

    @JsonIgnore
    private Long longDate;

    private String date;

}
