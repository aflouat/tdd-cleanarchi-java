package com.wealcome.nextride.adapters.primary.springboot.controllers;

import com.wealcome.nextride.adapters.secondary.gateways.repositories.FakeRideRepository;
import com.wealcome.nextride.businesslogic.gateways_secondaryports.RideRepository;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCase;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCaseCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.UUID;

@Controller
public class RideController {

    private final BookRideUseCase bookRideUseCase;

    public RideController(BookRideUseCase bookRideUseCase) {
        this.bookRideUseCase = bookRideUseCase;
    }

    @PostMapping("/rides")
    public ResponseEntity<Void> bookRide(@RequestBody RideBookingBodyParams params) {
        bookRideUseCase.handle(
                new BookRideUseCaseCommand(
                        params.rideId(),
                        UUID.fromString("a47b3b2d-3f3b-4f6d-8b0f-4f6d8b0f4f6d"),
                        params.departure(),
                        params.arrival(),
                        params.wantsUberX(),
                        false
                )
        );
        return ResponseEntity.created(URI.create("/rides/" + params.rideId())).build();
    }

    record RideBookingBodyParams(UUID rideId,
                                 String departure,
                                 String arrival,
                                 boolean wantsUberX) {
    }

}
