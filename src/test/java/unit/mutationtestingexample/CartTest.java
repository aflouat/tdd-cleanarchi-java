package unit.mutationtestingexample;

import com.wealcome.mutationtestingexample.Cart;
import com.wealcome.mutationtestingexample.OrderLine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    void canPriceACart() {
        Cart cart = new Cart();
        cart.addOrderLines(new OrderLine("SomeBook", 10.1, 1));
        assertThat(cart.price()).isEqualTo(10.1);
    }

    @Test
    void canPriceACart2() {
        Cart cart = new Cart();
        cart.addOrderLines(new OrderLine("SomeBook2", 10.1, 2));
        assertThat(cart.price()).isEqualTo(20.2);
    }

}
