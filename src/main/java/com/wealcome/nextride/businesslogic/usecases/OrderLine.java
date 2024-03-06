package com.wealcome.nextride.businesslogic.usecases;

public class OrderLine {

    private final double price;
    private final double quantity;

    public OrderLine(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }
}
