package geometries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import primitives.*;
/**
 * Testing Tube
 *
 * @author Dan
 *
 */
class TubeTest {

    /**
     * Test method for getNormal func who get a point as parameter.
     */
    @Test
    public void testGetNormal() {
        Vector vec = new Vector(1, 1, 1);
        Point pt = new Point(2, 2, 2);
        Ray ray = new Ray(pt, vec);
        Tube tube = new Tube(ray, 5);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Wrong normal calculation (in case the point is not across the ray.p0)
        assertEquals(new Vector(Math.sqrt(1/2d),-1 * Math.sqrt(1/2d),0), tube.getNormal(new Point(12,2,7))
                ,"getNormal() - does not work correctly");

        // =============== Boundary Values Tests ==================

        // TC01: Wrong normal calculation (in case the point is across the ray.p0)
        assertEquals(new Vector(Math.sqrt(1/2d),-1 * Math.sqrt(1/2d),0), tube.getNormal(new Point(7, -3, 2))
                ,"getNormal() - does not work correctly (Boundary test)");
    }
}