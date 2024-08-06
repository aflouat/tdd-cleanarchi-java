package com.wealcome.nextride.businesslogic.usecases.ridebooking;

import com.wealcome.nextride.businesslogic.models.DateTimeProvider;
import com.wealcome.nextride.businesslogic.models.Ride;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.TripScannerGateway;

public class BookRideUseCase {
    private final RideRepository rideRepository;
    private final TripScannerGateway tripScannerGateway;
    private final DateTimeProvider dateTimeProvider;

    public BookRideUseCase(RideRepository rideRepository,
                           TripScannerGateway tripScannerGateway,
                           DateTimeProvider dateTimeProvider) {
        this.rideRepository = rideRepository;
        this.tripScannerGateway = tripScannerGateway;
        this.dateTimeProvider = dateTimeProvider;
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
                isArrivalInParis,
                dateTimeProvider.now()
        );
        rideRepository.save(ride);
    }
}
