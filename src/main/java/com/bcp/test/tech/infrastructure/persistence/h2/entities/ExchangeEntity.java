package com.bcp.test.tech.infrastructure.persistence.h2.entities;

import com.bcp.test.tech.infrastructure.persistence.h2.entities.common.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

// Lombok annotations

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)

// JPA annotations

@Entity(name = "exchange")
@Table(name = "EXCHANGE")
public class ExchangeEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXC")
    private Long id;

    @Column(name = "AMNT")
    private BigDecimal amount;

    @Column(name = "AMNT_EXCD")
    private BigDecimal amountExchanged;

    @ManyToOne
    @JoinColumn(name = "ID_ORG_CN")
    private CoinEntity originCoin;

    @ManyToOne
    @JoinColumn(name = "ID_DST_CN")
    private CoinEntity destinationCoin;

    @ManyToOne
    @JoinColumn(name = "ID_CHG")
    private ChangeEntity changeApplied;

    @Column(name = "EXCD_AMNT")
    private BigDecimal exchangeAmount;

}
