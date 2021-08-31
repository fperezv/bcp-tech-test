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
import java.util.Date;

// Lombok annotations

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)

// JPA annotations

@Entity(name = "change")
@Table(name = "CHANGE")
public class ChangeEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHG")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_ORG_CN")
    private CoinEntity originCoin;

    @ManyToOne
    @JoinColumn(name = "ID_DST_CN")
    private CoinEntity destinationCoin;

    @Column(name = "IN_CHG")
    private Boolean in;

    @Column(name = "AMNT_CHG")
    private BigDecimal amount;

    @Column(name = "DT_CHG")
    private Date date;

}
