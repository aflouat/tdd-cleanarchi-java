package com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning;

import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;

import java.util.HashMap;
import java.util.Map;

public class DemoFakeTripScannerGateway implements TripScannerGateway {

    public Map<String, Float> distance = Map.of(
            "8 avenue Foch PARIS _ 18 avenue Foch PARIS", 3.0f,
            "111 avenue Victor Hugo Aubervilliers _ 18 avenue Foch PARIS", 10.0f
    );

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
