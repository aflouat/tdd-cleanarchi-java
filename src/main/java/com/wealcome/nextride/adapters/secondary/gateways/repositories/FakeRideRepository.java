package com.wealcome.nextride.adapters.secondary.gateways.repositories;

import com.wealcome.nextride.businesslogic.models.Ride;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeRideRepository implements RideRepository {

    private final List<Ride> rides = new ArrayList<>();

    @Override
    public void save(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> rides() {
        return rides;
    }
}
