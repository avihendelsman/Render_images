package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Plane
 *
 * @author
 *
 */
class PlaneTest {

    /**
     * Test method for ctor who get 3 point.
     */
    @Test
    public void testPlane() {

        // =============== Boundary Values Tests ==================

        // Test for 2 similar points
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 2, 3), new Point(1, 2, 3), new Point(0, 0, 0))
                ,"Constructed a Plane with same points not valid");

        // Check for 3 points on one straight line
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 1, 1), new Point(2, 2, 2), new Point(3, 3, 3))
                ,"Constructed a Plane with points on one straight line is not valid");
    }

    /**
     * Test method for getNormal func who get a point as parameter.
     */
    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============

        // TC01: There is a simple single test here. The normal vector is (1,1,1)
        Plane pl = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

        double sqrt3 = Math.sqrt(1d / 3); // Normalizing the vector components

        // Two opposite sides of the vector must be checked:
        assertTrue(new Vector(sqrt3, sqrt3, sqrt3).equals(pl.getNormal(new Point(0, 0, 1)))
                || new Vector(-1 * sqrt3, -1 * sqrt3, -1 * sqrt3).equals(pl.getNormal(new Point(0, 0, 1)))
                ,"Bad normal to plane");
    }

    /**
     * Test for findIntsersections method.
     */
    @Test
    public void testFindIntersections() {

        Plane plane = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

        // ============ Equivalence Partitions Tests ==============

        // **** Group:The Ray must be neither orthogonal nor parallel to the plane

        // TC01: Ray intersects the plane(1 point)
        List<Point> result = plane.findIntsersections(new Ray(new Point(2, 4, 0),new Vector(-3, -1, 0)));
        assertEquals(1, result.size(),"Wrong number of points");
        assertEquals(new Point(-1.75, 2.75, 0), result.get(0),"Ray crosses plane once");

        // TC02: Ray does not intersect the plane(0 point)
        assertNull(plane.findIntsersections(new Ray(new Point(2, 4, 0),new Vector(3, 4, 0)))
                ,"Ray's crosses the plane");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray is parallel to the plane

        // TC10: The ray is not included in the plane
        assertNull(plane.findIntsersections(new Ray(new Point(-1, -1, 0),new Vector(-1, 1, 0)))
                ,"Ray's crosses the plane");

        // TC11: The ray included in the plane
        assertNull(plane.findIntsersections(new Ray(new Point(1, -1, 1),new Vector(-1, 1, 0)))
                ,"Ray's crosses the plane");

        // **** Group: Ray is orthogonal to the plane

        // TC12: The ray starts is before the plane
        result = plane.findIntsersections(new Ray(new Point(-1, -1, 0),new Vector(1, 1, 1)));
        assertEquals(1, result.size(),"Wrong number of points");
        assertEquals(new Point(0, 0, 1), result.get(0),"Ray crosses plane once");

        // TC13: The ray starts is in the plane
        assertNull(plane.findIntsersections(new Ray(new Point(1, -1, 1),new Vector(1, 1, 1)))
                ,"Ray's crosses the plane");

        // TC14: The ray starts is after the plane
        assertNull(plane.findIntsersections(new Ray(new Point(2, 0, 0),new Vector(1, 1, 1)))
                ,"Ray's crosses the plane");

        // ***********

        // TC15: Ray is neither orthogonal nor parallel to and begins at the plane
        assertNull(plane.findIntsersections(new Ray(new Point(1, -1, 1),new Vector(-3, -1, 0)))
                ,"Ray's crosses the plane");

        // TC16: Ray is neither orthogonal nor parallel to the plane and begins in the
        // same point
        assertNull(plane.findIntsersections(new Ray(new Point(1, 0, 0),new Vector(-3, -1, 0)))
                ,"Ray's crosses the plane");
    }
}