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
import javax.persistence.Table;

// Lombok annotations

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)

// JPA annotations

@Entity(name = "coin")
@Table(name = "COIN")
public class CoinEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CN")
    public Long id;

    @Column(name = "SHT_NAM")
    public String shortName;

    @Column(name = "NAM_CN")
    public String name;

    @Column(name = "SBL_CN")
    public String symbol;

}
