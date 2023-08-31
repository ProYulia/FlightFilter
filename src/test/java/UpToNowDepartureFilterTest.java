import com.gridnine.testing.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UpToNowDepartureFilterTest {

    private List<Flight> flights;
    private Filter filter;

    @Test
    public void shouldReturnNoDeparturesBeforeNow() {

        Flight spy = flights.get(2);
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
        filter = new Filter(new UpToNowDepartureFilter());
    }
}
