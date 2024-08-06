package com.wealcome.integration.configuration;

import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.JpaRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.SpringJpaRideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondaryAdaptersIntegrationTestConfiguration {


    @Bean
    public RideRepository rideRepository(SpringJpaRideRepository springJpaRideRepository) {
        return new JpaRideRepository(springJpaRideRepository);
    }

}
