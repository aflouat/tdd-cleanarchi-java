package com.wealcome.integration.adapters.secondary.gateways.repositories;

import com.wealcome.integration.AbstractBaseIntegration;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.JpaRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.SpringJpaRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.entities.RideJpaEntity;
import com.wealcome.nextride.businesslogic.models.Ride;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

public class JpaRideRepositoryIT extends AbstractBaseIntegration {

    @Autowired
    private JpaRideRepository jpaRideRepository;

    @Autowired
    private SpringJpaRideRepository springJpaRideRepository;

    @Test
    void can_save_a_ride() {
        // Given
        var ride = new Ride(
                UUID.fromString("f47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                UUID.fromString("a57b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                "8 avenue Foch Paris",
                "18 avenue Foch Paris",
                3,
                false,
                valueOf(10.5)
        );
        // When
        jpaRideRepository.save(ride);
        // Then
        var savedRides = springJpaRideRepository.findAll();
        var expectedRideJpaEntity = new RideJpaEntity(
                UUID.fromString("f47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                UUID.fromString("a57b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                "8 avenue Foch Paris",
                "18 avenue Foch Paris",
                3,
                false,
                valueOf(10.5)
        );
        assertThat(savedRides).containsExactly(expectedRideJpaEntity);
    }

}
