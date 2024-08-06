package com.wealcome.unit.mutationtestingexample;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    void canPriceASingleProductCart() {
        Cart cart = new Cart();
        cart.addProduct(new OrderLine("Some Book", 10));
        assertThat(cart.price()).isEqualTo(10);
        assertThat(cart.getOrderLines()).isEqualTo(
                Map.of("Some Book", new OrderLine("Some Book", 10)));
    }

    @Test
    void canPriceAMultipleProductsCart() {
        Cart cart = new Cart();
        cart.addProduct(new OrderLine("Some Book", 10));
        cart.addProduct(new OrderLine("Piano", 1000));
        assertThat(cart.price()).isEqualTo(1010);
        assertThat(cart.getOrderLines()).isEqualTo(
                Map.of("Some Book", new OrderLine("Some Book", 10),
                        "Piano", new OrderLine("Piano", 1000)));
    }

    @Test
    void canPriceASameProductBoughtSeveralTime() {
        Cart cart = new Cart();
        cart.addProduct(new OrderLine("Some Book", 10, 2));
        assertThat(cart.price()).isEqualTo(20);
        assertThat(cart.getOrderLines()).isEqualTo(
                Map.of("Some Book", new OrderLine("Some Book", 10, 2)));
    }

    @Test
    void canConsiderDistinctAdditionOfTheSameProductAsSameAddition() {
        Cart cart = new Cart();
        cart.addProduct(new OrderLine("Some Book", 10));
        cart.addProduct(new OrderLine("Some Book", 10));
        assertThat(cart.price()).isEqualTo(20);
        assertThat(cart.getOrderLines()).isEqualTo(
                Map.of("Some Book", new OrderLine("Some Book", 10, 2)));
    }

}

class Cart {

    private final Map<String, OrderLine> orderLines = new HashMap<>();

    public int price() {
        return orderLines.values().stream()
                .mapToInt(OrderLine::price)
                .sum();
    }

    public void addProduct(OrderLine orderLine) {
        orderLines.merge(orderLine.getLabel(), orderLine, OrderLine::mergeWith);
    }

    public Map<String, OrderLine> getOrderLines() {
        return orderLines;
    }


}

@EqualsAndHashCode
@ToString
class OrderLine {

    @Getter
    private final String label;
    private final int price;
    private final int quantity;

    public OrderLine(String label, int price) {
        this(label, price, 1);
    }

    public OrderLine(String label, int price, int quantity) {
        this.label = label;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderLine mergeWith(OrderLine orderLine) {
        return new OrderLine(label, price, quantity + orderLine.quantity);
    }

    public int price() {
        return price * quantity;
    }
}
