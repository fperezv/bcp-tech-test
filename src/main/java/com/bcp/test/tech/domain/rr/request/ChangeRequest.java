package com.bcp.test.tech.domain.rr.request;

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
public class ChangeRequest {

    private BigDecimal amount;

    private String originCoin;

    private String destinationCoin;

    private Boolean in;

    private Long date;

}
