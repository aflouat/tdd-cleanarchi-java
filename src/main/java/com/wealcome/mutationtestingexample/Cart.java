package com.wealcome.mutationtestingexample;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Cart {

    private final Set<OrderLine> orderLines = new HashSet<>();

    public void addOrderLines(OrderLine... orderLine) {
        Collections.addAll(orderLines, orderLine);
    }

    public double price() {
        var total = 0;
        var orderLine = orderLines.iterator().next();
        if (orderLine.price() >= 0) {
            return total + orderLine.price() * orderLine.quantity();
        }
        return total;

    }
}
