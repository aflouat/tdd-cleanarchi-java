package com.wealcome.nextride.adapters.primary.springboot.configuration;

import com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning.DemoFakeTripScannerGateway;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.JpaRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.SpringJpaRideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;
import com.wealcome.nextride.businesslogic.models.DeterministicDateProvider;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.wealcome.nextride")
@EnableJpaRepositories("com.wealcome.nextride")
@Configuration
public class SpringConfiguration {

    @Bean
    public BookRideUseCase bookRideUseCase(RideRepository rideRepository,
                                    TripScannerGateway tripScannerGateway) {
        return new BookRideUseCase(rideRepository, tripScannerGateway, new DeterministicDateProvider());
    }

    @Bean
    public RideRepository rideRepository(SpringJpaRideRepository springJpaRideRepository) {
        return new JpaRideRepository(springJpaRideRepository);
    }

    @Bean
    public TripScannerGateway tripScannerGateway() {
        return new DemoFakeTripScannerGateway();
    }



}
