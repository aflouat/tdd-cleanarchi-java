package unit.BusinessLogic.RideBooking;

import com.wealcome.nextride.adapters.secondary.gateways.repositories.FakeRideRepository;
import com.wealcome.nextride.adapters.secondary.gateways.providers.tripscanning.FakeTripScannerGateway;
import com.wealcome.nextride.businesslogic.models.Ride;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCase;
import com.wealcome.nextride.businesslogic.usecases.ridebooking.BookRideUseCaseCommand;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.UUID;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookRideUseCaseTest {

    private final UUID rideId = UUID.fromString("c1b4b3b4-0b3b-4b3b-8b3b-0b3b4b3b4b3b");
    private final UUID riderId = UUID.fromString("bb6632a6-877c-4d18-8c35-bbbbdabc9f8e");
    private final FakeRideRepository rideRepository = new FakeRideRepository();
    private final FakeTripScannerGateway tripScannerGateway = new FakeTripScannerGateway();
    private final String PARIS_ADDRESS = "PARIS_ADDRESS";
    private final String OUTSIDE_ADDRESS = "OUTSIDE_ADDRESS";


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
        whenAttemptingToBookARide(departure, arrival,false, false);
        thenBookedRidesAre(new Ride(
                rideId,
                riderId,
                departure,
                arrival,
                distance,
                false,
                expectedPrice
        ));
    }

    @Test
    public void a_long_ride_with_UberX_Is_Offered_On_Rider_Birthday() {
        givenDistanceIs(3);
        whenAttemptingToBookARide(PARIS_ADDRESS, PARIS_ADDRESS,true, true);
        thenBookedRidesAre(new Ride(
                rideId,
                riderId,
                PARIS_ADDRESS,
                PARIS_ADDRESS,
                3,
                true,
                valueOf(3.5)
        ));
    }

    @Test
    public void a_long_ride_with_UberX_Is_Taxed_Additionally_When_Not_Rider_Birthday() {
        givenDistanceIs(3);
        whenAttemptingToBookARide(PARIS_ADDRESS, PARIS_ADDRESS,true, false);
        thenBookedRidesAre(new Ride(
                rideId,
                riderId,
                PARIS_ADDRESS,
                PARIS_ADDRESS,
                3,
                true,
                valueOf(8.5)
        ));
    }

    private void whenAttemptingToBookARide(String departure, String arrival, boolean wantsUberX, boolean isRiderBirthday) {
        new BookRideUseCase(rideRepository, tripScannerGateway)
                .handle(new BookRideUseCaseCommand(rideId, riderId, departure, arrival, wantsUberX, isRiderBirthday));
    }

    @Test
    public void a_short_ride_with_UberX_Is_Prevented() {
        givenDistanceIs(1);
        assertThatThrownBy(() -> whenAttemptingToBookARide(PARIS_ADDRESS, PARIS_ADDRESS, true, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("UberX is only available for rides longer than 3km");
        thenBookedRidesAre();
    }

    private void thenBookedRidesAre(Ride... rides) {
        assertThat(rideRepository.rides()).containsExactly(rides);
    }

    private void givenDistanceIs(int distance) {
        tripScannerGateway.setDistance(PARIS_ADDRESS, PARIS_ADDRESS, distance);
    }
}
