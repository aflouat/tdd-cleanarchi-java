package com.wealcome.nextride.businesslogic.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Ride {

    private final UUID id;
    private final UUID riderId;
    private final String departure;
    private final String arrival;
    private final float distance;
    private final boolean wantsUberX;
    private final BigDecimal price;

    public static Ride book(
            UUID rideId,
            UUID riderId,
            String departure,
            String arrival,
            float distance,
            boolean wantsUberX,
            boolean isRiderBirthday,
            boolean isDepartureInParis,
            boolean isArrivalInParis,
            LocalDateTime currentDate
    ) {
        if (distance < 3 && wantsUberX)
            throw new IllegalArgumentException("UberX is only available for rides longer than 3km");
        var basePrice = 10;
        if (isArrivalInParis)
            basePrice = 2;
        if (!isDepartureInParis) {
            if (isArrivalInParis)
                basePrice = 20;
            else
                basePrice = 50;
        }
        var price = basePrice + 0.5 * distance;
        if (!isRiderBirthday && wantsUberX)
            price += 5;


        if (currentDate.getMonthValue() == 12 && currentDate.getDayOfMonth() == 25)
            price *= 2;

        return new Ride(
                rideId,
                riderId,
                departure,
                arrival,
                distance,
                wantsUberX,
                BigDecimal.valueOf(price)
        );
    }

}
