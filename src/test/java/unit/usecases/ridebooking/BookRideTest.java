package unit.usecases.ridebooking;

import com.wealcome.nextride.businesslogic.usecases.BookRide;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRideTest {

    @Test
    public void testBookRide() {
        var result = new BookRide().handle(List.of(3.0));
        assertThat(result).isEqualTo("Ride booked!");
    }

    @Test
    public void testBookRide2() {
        var result = new BookRide().handle(List.of(1.0));
        assertThat(result).isEqualTo("Ride not booked!");
    }

}
