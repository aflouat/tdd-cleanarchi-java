package com.wealcome.nextride.businesslogic.usecases.ridebooking;

import com.wealcome.nextride.businesslogic.models.Ride;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;

public class BookRideUseCase {
    private final RideRepository rideRepository;
    private final TripScannerGateway tripScannerGateway;

    public BookRideUseCase(RideRepository rideRepository,
                           TripScannerGateway tripScannerGateway) {
        this.rideRepository = rideRepository;
        this.tripScannerGateway = tripScannerGateway;
    }

    public void handle(BookRideUseCaseCommand command) {
        var distance = tripScannerGateway.distanceBetween(command.departure(), command.arrival());
        var isDepartureInParis = tripScannerGateway.isAddressInParis(command.departure());
        var isArrivalInParis = tripScannerGateway.isAddressInParis(command.arrival());

        var ride = Ride.book(
                command.rideId(),
                command.riderId(),
                command.departure(),
                command.arrival(),
                distance,
                command.wantsUberX(),
                command.isRiderBirthday(),
                isDepartureInParis,
                isArrivalInParis
        );
        rideRepository.save(ride);
    }
}
