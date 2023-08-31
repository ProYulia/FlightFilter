import com.gridnine.testing.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TimeBetweenDeparturesGreaterThanTwoHoursFilterTest {
    private List<Flight> flights;
    private Filter filter;

    @Test
    public void shouldReturnNoLongGroundTimeFlights() {

        Flight spy1 = flights.get(4);
        Flight spy2 = flights.get(5);
        List<Flight> result = filter.filter(flights);

        Assert.assertFalse(result.contains(spy1));
        Assert.assertFalse(result.contains(spy2));
    }

    @Test
    public void shouldReturnCorrectSize() {

        List<Flight> result = filter.filter(flights);

        Assert.assertEquals(4, result.size());
    }


    @Before
    public void init() {
        flights = FlightBuilder.createFlights();
        filter = new Filter(new TimeBetweenDeparturesGreaterThanTwoHoursFilter());
    }
}
