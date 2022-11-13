package org.wahlzeit.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    @Test
    public void testCartesianCoordinateConstructor(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);

        assertEquals(x, coordinate.getX(), 0);
        assertEquals(y, coordinate.getY(), 0);
        assertEquals(z, coordinate.getZ(), 0);
    }

    @Test
    public void testCartesianEqualsPositive(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        CartesianCoordinate coordinate1 = new CartesianCoordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 4.2;

        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testCartesianEqualsNegative(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        CartesianCoordinate coordinate1 = new CartesianCoordinate(x, y, z);

        double x2 = 0.4;
        double y2 = 6.9;
        double z2 = 0.2;

        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void testGetCartesianDistance(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        CartesianCoordinate coordinate1 = new CartesianCoordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 5.2;

        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertEquals(0, coordinate1.getCartesianDistance(coordinate1), 0);
        assertEquals(1, coordinate1.getCartesianDistance(coordinate2), 0);

    }

    @Test
    public void testSphericCoordinateConstructor(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        SphericCoordinate coordinate = new SphericCoordinate(x, y, z);

        assertEquals(x, coordinate.getPhi(), 0);
        assertEquals(y, coordinate.getTheta(), 0);
        assertEquals(z, coordinate.getRadius(), 0);
    }

    @Test
    public void testSphericEqualsPositive(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        CartesianCoordinate coordinate1 = new CartesianCoordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 4.2;

        CartesianCoordinate coordinate2 = new CartesianCoordinate(x2, y2, z2);

        assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testSphericEqualsNegative(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        SphericCoordinate coordinate1 = new SphericCoordinate(x, y, z);

        double x2 = 0.4;
        double y2 = 6.9;
        double z2 = 0.2;

        SphericCoordinate coordinate2 = new SphericCoordinate(x2, y2, z2);

        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void testGetCartesianDistanceOnSphericCoordinate(){
        double x = 0.5;
        double y = 1.9;
        double z = 4.2;

        SphericCoordinate coordinate1 = new SphericCoordinate(x, y, z);

        double x2 = 0.5;
        double y2 = 1.9;
        double z2 = 5.2;

        SphericCoordinate coordinate2 = new SphericCoordinate(x2, y2, z2);

        assertEquals(0, coordinate1.getCartesianDistance(coordinate1), 0);
        assertEquals(1, coordinate1.getCartesianDistance(coordinate2), 0.1);

    }

}
