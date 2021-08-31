package com.bcp.test.tech.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ExchangeModel {

    @JsonIgnore
    private Long id;

    @JsonProperty("monto")
    private BigDecimal amount;

    @JsonProperty("montoConTipoDeCambio")
    private BigDecimal amountExchanged;

    @JsonIgnore
    private CoinModel originCoin;

    @JsonProperty("monedaOrigen")
    private String originCoinName;

    @JsonIgnore
    private CoinModel destinationCoin;

    @JsonProperty("monedaDestino")
    private String destinationCoinName;

    @JsonIgnore
    private ChangeModel change;

    @JsonProperty("tipoDeCambio")
    private BigDecimal exchangeAmount;

}
