package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Cylinder
 *
 * @author
 *
 */
class CylinderTest {

    /**
     * Test method for getNormal func who get a point as parameter.
     */
    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============

        var cylinder = new Cylinder(new Ray(new Point(0, 0, 1), new Vector(0, 0, 1)), 1, 9);

        // TC01: Check that the normal is correct on body
        assertEquals(new Vector(1, 0, 0), cylinder.getNormal(new Point(1, 0, 6))
                ,"getNormal(Point3D) -The normal to the Tube is not correct ");

        // TC02:Check that the normal is correct on top cup
        assertEquals(new Vector(0, 0, 1), cylinder.getNormal(new Point(0.5, 0.5, 10))
                ,"getNormal(Point3D) -The normal to the Tube is not correct ");

        // TC03:Check that the normal is correct on under cup
        assertEquals(new Vector(0, 0, 1), cylinder.getNormal(new Point(0.5, 0.5, 1))
                ,"getNormal(Point3D) -The normal to the Tube is not correct ");

        // =============== Boundary Values Tests ==================

        // TC04: Check when the point is in center of top cup
        assertEquals(new Vector(0, 0, 1), cylinder.getNormal(new Point(0, 0, 10))
                ,"getNormal() faild - point is in center of top cup!");

        // TC05: Check when the point is in center of under cup
        assertEquals(new Vector(0, 0, 1), cylinder.getNormal(new Point(0, 0, 1))
                ,"getNormal() faild - point is in center of under cup!");
    }
}