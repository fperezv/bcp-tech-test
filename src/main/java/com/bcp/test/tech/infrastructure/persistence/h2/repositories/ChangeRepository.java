package com.bcp.test.tech.infrastructure.persistence.h2.repositories;

import com.bcp.test.tech.infrastructure.persistence.h2.entities.ChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChangeRepository extends JpaRepository<ChangeEntity, Long> {

    Optional<ChangeEntity> findFirstByOriginCoinIdAndDestinationCoinIdOrderByDateDesc(
            Long originCoinId,
            Long destinationCoinId
    );

}
