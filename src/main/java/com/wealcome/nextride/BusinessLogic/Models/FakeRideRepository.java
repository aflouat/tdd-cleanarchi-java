package com.wealcome.nextride.BusinessLogic.Models;

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
