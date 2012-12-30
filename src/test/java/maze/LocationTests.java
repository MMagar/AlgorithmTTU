package maze;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LocationTests {
    @Test
    public void compareLocations() throws Exception {
        Location first = new Location(1,1);
        Location second = new Location(1,1);

        assertTrue(first.equals(second));
    }

    @Test
    public void checkIfArrayContainsLocation() throws Exception {
        Location first = new Location(1,1);
        Location second = new Location(1,1);
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(first);

        assertTrue(locations.contains(second));
    }
}
