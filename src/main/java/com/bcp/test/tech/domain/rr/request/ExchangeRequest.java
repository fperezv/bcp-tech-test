package com.bcp.test.tech.domain.rr.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@FieldNameConstants
public class ExchangeRequest {

    @JsonProperty("monto")
    private BigDecimal amount;

    @JsonProperty("monedaOrigen")
    private String originCoin;

    @JsonProperty("monedaDestino")
    private String destinationCoin;

}
