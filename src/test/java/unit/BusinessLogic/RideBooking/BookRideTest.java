package unit.BusinessLogic.RideBooking;

import com.wealcome.nextride.BusinessLogic.Models.FakeRideRepository;
import com.wealcome.nextride.BusinessLogic.Models.FakeTripScannerGateway;
import com.wealcome.nextride.BusinessLogic.Models.Ride;
import com.wealcome.nextride.BusinessLogic.UseCases.RideBooking.BookRide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRideTest {

    private final UUID rideId = UUID.fromString("c1b4b3b4-0b3b-4b3b-8b3b-0b3b4b3b4b3b");
    private final UUID riderId = UUID.fromString("bb6632a6-877c-4d18-8c35-bbbbdabc9f8e");
    private final FakeRideRepository rideRepository = new FakeRideRepository();
    private final FakeTripScannerGateway tripScannerGateway = new FakeTripScannerGateway();


    @ParameterizedTest
    @CsvSource({
            "PARIS_ADDRESS, PARIS_ADDRESS, 1, 2.5",
            "PARIS_ADDRESS, OUTSIDE_ADDRESS, 1, 10.5",
            "OUTSIDE_ADDRESS, PARIS_ADDRESS, 1, 20.5",
            "OUTSIDE_ADDRESS, OUTSIDE_ADDRESS, 1, 50.5",
            "OUTSIDE_ADDRESS, OUTSIDE_ADDRESS, 2, 51.0",
    })
    void can_book_a_short_ride_without_exceptional_context(String departure, String arrival,
                                                           float distance, BigDecimal expectedPrice) {
        tripScannerGateway.setDistance(departure, arrival, distance);
        new BookRide(rideRepository, tripScannerGateway)
                .handle(rideId, riderId, departure, arrival);
        assertThat(rideRepository.rides()).containsExactly(
                new Ride(
                        rideId,
                        riderId,
                        departure,
                        arrival,
                        distance,
                        expectedPrice
                )
        );
    }


}
