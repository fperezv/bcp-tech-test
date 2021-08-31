package com.bcp.test.tech.infrastructure.persistence.h2.repositories;

import com.bcp.test.tech.infrastructure.persistence.h2.entities.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}
