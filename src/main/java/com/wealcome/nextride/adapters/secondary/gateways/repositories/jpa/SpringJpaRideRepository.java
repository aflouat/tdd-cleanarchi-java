package com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa;

import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.entities.RideJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaRideRepository extends JpaRepository<RideJpaEntity, UUID> {
}
