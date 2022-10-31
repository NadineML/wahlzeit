package org.wahlzeit.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    @Test
    public void testCoordinateConstructor(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        Coordinate coordinate = new Coordinate(x, y, z);

        assertEquals(x, coordinate.getX(), 0);
        assertEquals(y, coordinate.getY(), 0);
        assertEquals(z, coordinate.getZ(), 0);
    }

    @Test
    public void testEqualsPositive(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        Coordinate coordinate1 = new Coordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 4.2;

        Coordinate coordinate2 = new Coordinate(x2, y2, z2);

        assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testEqualsNegative(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        Coordinate coordinate1 = new Coordinate(x, y, z);

        double x2 = 0.4;
        double y2 = 6.9;
        double z2 = 0.2;

        Coordinate coordinate2 = new Coordinate(x2, y2, z2);

        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void testGetDistance(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        Coordinate coordinate1 = new Coordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 5.2;

        Coordinate coordinate2 = new Coordinate(x2, y2, z2);

        assertEquals(0, coordinate1.getDistance(coordinate1), 0);
        assertEquals(1, coordinate1.getDistance(coordinate2), 0);

    }

}
