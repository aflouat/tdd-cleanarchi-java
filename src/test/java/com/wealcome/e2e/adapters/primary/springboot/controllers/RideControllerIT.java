package com.wealcome.e2e.adapters.primary.springboot.controllers;

import com.wealcome.e2e.AbstractBaseE2E;
import com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning.FakeTripScannerGateway;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.SpringJpaRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.entities.RideJpaEntity;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RideControllerIT extends AbstractBaseE2E {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SpringJpaRideRepository springJpaRideRepository;

    @Autowired
    private TripScannerGateway tripScannerGateway;

    @Test
    void book_a_basic_ride() throws Exception {
        ((FakeTripScannerGateway) tripScannerGateway).setDistance(
                "8 avenue Foch PARIS",
                "18 avenue Foch PARIS",
                3.0f
        );
        mockMvc.perform(
                        post("/rides")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "rideId": "f47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d",
                                            "departure": "8 avenue Foch PARIS",
                                            "arrival": "18 avenue Foch PARIS",
                                            "wantsUberX": false
                                        }
                                        """)
                )
                .andExpect(status().isCreated());
        var rideJpaEntities = springJpaRideRepository.findAll();
        assertThat(rideJpaEntities).containsExactly(
                new RideJpaEntity(
                        UUID.fromString("f47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                        UUID.fromString("a47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                        "8 avenue Foch PARIS",
                        "18 avenue Foch PARIS",
                        3,
                        false,
                        new BigDecimal("3.50")
                )
        );
    }


}
