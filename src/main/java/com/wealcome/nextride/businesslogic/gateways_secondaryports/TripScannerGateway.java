package com.wealcome.nextride.businesslogic.gateways_secondaryports;

public interface TripScannerGateway {

    float distanceBetween(String departure, String arrival);

    boolean isAddressInParis(String address);
}
