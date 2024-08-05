package com.wealcome.nextride.BusinessLogic.UseCases.RideBooking;

import com.wealcome.nextride.BusinessLogic.Models.*;

import java.util.UUID;

public class BookRide {
    private final RideRepository rideRepository;
    private final TripScannerGateway tripScannerGateway;

    public BookRide(RideRepository rideRepository,
                    TripScannerGateway tripScannerGateway) {
        this.rideRepository = rideRepository;
        this.tripScannerGateway = tripScannerGateway;
    }

    public void handle(UUID rideId, UUID riderId, String departure, String arrival) {
        var distance = tripScannerGateway.distanceBetween(departure, arrival);
        var isDepartureInParis = tripScannerGateway.isAddressInParis(departure);
        var isArrivalInParis = tripScannerGateway.isAddressInParis(arrival);
        var ride = Ride.book(
                rideId,
                riderId,
                departure,
                arrival,
                distance,
                isDepartureInParis,
                isArrivalInParis
        );
        rideRepository.save(ride);
    }
}
