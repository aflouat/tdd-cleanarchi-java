package com.wealcome.nextride.BusinessLogic.Models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Ride {

    private final UUID rideId;
    private final UUID riderId;
    private final String departure;
    private final String arrival;
    private final float distance;
    private final BigDecimal price;

    public static Ride book(
            UUID rideId,
            UUID riderId,
            String departure,
            String arrival,
            float distance,
            boolean isDepartureInParis,
            boolean isArrivalInParis
    ) {
        var basePrice = 10;
        if(isArrivalInParis)
            basePrice = 2;
        if(!isDepartureInParis) {
            if(isArrivalInParis)
                basePrice = 20;
            else
                basePrice = 50;
        }
        var price = basePrice + 0.5 * distance;
        return new Ride(
                rideId,
                riderId,
                departure,
                arrival,
                distance,
                BigDecimal.valueOf(price)
        );
    }
}
