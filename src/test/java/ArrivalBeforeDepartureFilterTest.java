import com.gridnine.testing.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.Filter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ArrivalBeforeDepartureFilterTest {

    private List<Flight> flights;
    private Filter filter;

    @Test
    public void shouldReturnNoArrivalsBeforeDepartures() {

        Flight spy = flights.get(3);
        List<Flight> result = filter.filter(flights);

        Assert.assertFalse(result.contains(spy));
    }

    @Test
    public void shouldReturnCorrectSize() {

        List<Flight> result = filter.filter(flights);

        Assert.assertEquals(5, result.size());
    }


    @Before
    public void init() {
        flights = FlightBuilder.createFlights();
        filter = new Filter(new ArrivalBeforeDepartureFilter());
    }
}
