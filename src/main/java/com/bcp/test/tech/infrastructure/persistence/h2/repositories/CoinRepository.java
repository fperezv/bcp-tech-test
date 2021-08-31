package com.bcp.test.tech.infrastructure.persistence.h2.repositories;

import com.bcp.test.tech.infrastructure.persistence.h2.entities.CoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<CoinEntity, Long> {

    Optional<CoinEntity> findByShortName(String shortName);
}
