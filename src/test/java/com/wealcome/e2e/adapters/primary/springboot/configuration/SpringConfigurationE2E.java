package com.wealcome.e2e.adapters.primary.springboot.configuration;

import com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning.FakeTripScannerGateway;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfigurationE2E {

    @Bean
    @Primary
    public TripScannerGateway tripScannerGatewayForE2E() {
        return new FakeTripScannerGateway();
    }
}
