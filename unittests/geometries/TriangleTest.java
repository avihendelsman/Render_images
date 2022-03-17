package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Triangle
 *
 * @author
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

    /**
     * Test method for findIntsersections func
     */
    @Test
    public void testFindIntersections() {

        Triangle tr = new Triangle(new Point(1,0,0), new Point(0, 1, 0), new Point(0, 0, 1));

        // ============ Equivalence Partitions Tests ==============

        // TC11: Inside polygon/triangle
        List<Point> result = tr.findIntsersections(new Ray(new Point(-1, -2, -1), new Vector(1, 2, 1)));
        assertEquals(1, result.size(),"Wrong number of points");
        assertEquals(new Point(0.25, 0.5, 0.25), result.get(0),"Ray crosses triangle once");

        // TC12: Outside against edge
        assertNull(tr.findIntsersections(new Ray(new Point(-1, -2, -1), new Vector(1, 3, 3)))
             ,"Ray's crosses outside the triangle");

        // TC13: Outside against vertex
        assertNull(tr.findIntsersections(new Ray(new Point(-1, -2, -1), new Vector(1, 2, 4)))
             ,"Ray's crosses outside the triangle");


        // =============== Boundary Values Tests ==================

        // ***** (the ray begins "before" the plane)

        // TC21: In vertex
        assertNull(tr.findIntsersections(new Ray(new Point(-1, -2, -1), new Vector(1, 2, 2)))
            ,"Ray's crosses the triangle's vertices");

        // TC22: On edge
        assertNull(tr.findIntsersections(new Ray(new Point(-1, -2, -1), new Vector(1.5, 2, 1.5)))
            ,"Ray's crosses the triangle's edge");

        // TC23: On edge's continuation
        assertNull(tr.findIntsersections(new Ray(new Point(-1, -2, -1),new Vector(0, 2, 3)))
            ,"Ray's crosses the triangle's edge");
    }
}