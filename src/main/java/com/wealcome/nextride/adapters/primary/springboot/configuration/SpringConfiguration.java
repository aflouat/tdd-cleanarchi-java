package com.wealcome.nextride.adapters.primary.springboot.configuration;

import com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning.DemoFakeTripScannerGateway;
import com.wealcome.nextride.adapters.secondary.gateways.repositories.FakeRideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public BookRideUseCase bookRideUseCase(RideRepository rideRepository,
                                    TripScannerGateway tripScannerGateway) {
        return new BookRideUseCase(rideRepository, tripScannerGateway);
    }

    @Bean
    public RideRepository rideRepository() {
        return new FakeRideRepository();
    }

    @Bean
    public TripScannerGateway tripScannerGateway() {
        return new DemoFakeTripScannerGateway();
    }



}
