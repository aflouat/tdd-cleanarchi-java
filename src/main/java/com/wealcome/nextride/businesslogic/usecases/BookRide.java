package com.wealcome.nextride.businesslogic.usecases;

import java.util.List;

public class BookRide {

    public String handle(List<Double> someList) {
        if (Math.floor(someList.get(0)) > 2)
            return "Ride booked!";
        return "Ride not booked!";
    }

}
