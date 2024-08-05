package com.wealcome.nextride.businesslogic.usecases.ridebooking;

import java.util.UUID;

public record BookRideUseCaseCommand(UUID rideId, UUID riderId, String departure, String arrival,
                                     boolean wantsUberX, boolean isRiderBirthday){}
