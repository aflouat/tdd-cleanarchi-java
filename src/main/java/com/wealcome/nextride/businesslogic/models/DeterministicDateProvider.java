package com.wealcome.nextride.businesslogic.models;

import java.time.LocalDateTime;

public class DeterministicDateProvider implements DateTimeProvider {

    public LocalDateTime currentDate;

    @Override
    public LocalDateTime now() {
        return currentDate;
    }
}
