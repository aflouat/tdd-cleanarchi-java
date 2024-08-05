package com.wealcome.nextride.BusinessLogic.Models;

import java.util.HashMap;
import java.util.Map;

public class FakeTripScannerGateway implements TripScannerGateway {

    public Map<String, Float> distance = new HashMap<>();

    @Override
    public float distanceBetween(String departure, String arrival) {
        var distance = this.distance.get(departure +  " _ " + arrival);
        if(distance == null)
            throw new IllegalStateException("Distance not found for " + departure + " -> " + arrival);
        return distance;
    }

    @Override
    public boolean isAddressInParis(String address) {
        return address.contains("PARIS");
    }

    public void setDistance(String departure, String arrival, float distance) {
        this.distance.put(departure +  " _ " + arrival, distance);
    }

}
