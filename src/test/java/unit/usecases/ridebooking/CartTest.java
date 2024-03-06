package unit.usecases.ridebooking;

import com.wealcome.nextride.businesslogic.usecases.Cart;
import com.wealcome.nextride.businesslogic.usecases.OrderLine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    public void testCalculateTotal() {
        assertThat(Cart.calculateTotal(List.of(new OrderLine(10.0, 1.0)))).isEqualTo(10.0);
    }

    @Test
    public void testCalculateTotal2() {
        assertThat(Cart.calculateTotal(List.of(new OrderLine(10.0, 1.0),
                new OrderLine(10.0, 1.0)))).isEqualTo(20.0);
    }

    @Test
    public void testCalculateTotal3() {
        assertThat(Cart.calculateTotal(List.of(new OrderLine(10.0, 2.0)))).isEqualTo(20.0);
    }

}
