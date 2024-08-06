package com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa;

import com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.entities.RideJpaEntity;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.models.Ride;

public class JpaRideRepository implements RideRepository {
    private final SpringJpaRideRepository springJpaRideRepository;

    public JpaRideRepository(SpringJpaRideRepository springJpaRideRepository) {
        this.springJpaRideRepository = springJpaRideRepository;
    }

    @Override
    public void save(Ride ride) {
        springJpaRideRepository.save(new RideJpaEntity(
                ride.getId(),
                ride.getRiderId(),
                ride.getDeparture(),
                ride.getArrival(),
                ride.getDistance(),
                ride.isWantsUberX(),
                ride.getPrice()
        ));
    }
}
