package com.wealcome.nextride.BusinessLogic.Models;

public interface TripScannerGateway {

    float distanceBetween(String departure, String arrival);

    boolean isAddressInParis(String address);
}
