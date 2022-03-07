package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Triangle
 *
 * @author Dan
 *
 */
class TriangleTest {

    /**
     * Test method for getNormal func who get a point as parameter.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Triangle triangle = new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3); // Normalizing the vector components
        assertTrue(new Vector(sqrt3, sqrt3, sqrt3).equals(triangle.getNormal(new Point(0, 0, 1)))
                ||  new Vector(-1 * sqrt3, -1 * sqrt3, -1 * sqrt3).equals(triangle.getNormal(new Point(0, 0, 1))),"Bad normal to plane");
    }
}