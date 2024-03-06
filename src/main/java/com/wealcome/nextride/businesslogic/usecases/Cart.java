package com.wealcome.nextride.businesslogic.usecases;

import java.util.List;

public class Cart {

    private Cart() {
        throw new UnsupportedOperationException("This class should not be instantiated");
    }

    public static double calculateTotal(List<OrderLine> orderLines) {
        return orderLines.stream()
                .mapToDouble(orderline -> orderline.getPrice() * orderline.getQuantity())
                .sum();
    }

}
