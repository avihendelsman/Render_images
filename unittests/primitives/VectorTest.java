package primitives;

import geometries.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 */
class VectorTest {
    //Vectors for tests
    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);

    /**
     * test Constructors
     */
    @Test
    void testConstructors() {
        // =============== Boundary Values Tests ==================

        // test zero vector for ctor get 3 doubles
        assertThrows(IllegalArgumentException.class, () -> new Vector(0, 0, 0),
                "ERROR: zero vector does not throw an exception");

        // test zero vector for ctor get Double3
        assertThrows(IllegalArgumentException.class, () -> new Vector(Double3.ZERO),
                "ERROR: zero vector does not throw an exception");
    }

    /**
     * test Add func
     */
    @Test
    void testAdd() {
        Vector v4 = new Vector(-1,-2,-3);
        // ============ Equivalence Partitions Tests ==============

        // TC01: Wrong vectors addition
        assertEquals(v4, v2.add(v1),
                "Vectors addition doesn't work");

        // TC02: Wrong vectors addition
        assertThrows(IllegalArgumentException.class, () -> v4.add(v1),
                "Vectors addition doesn't work");
    }

    /**
     * test Scale func
     */
    @Test
    void testScale() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Wrong vectors scale multiplication
        assertEquals(v2, v1.scale(-2), "scale() wrong scale multiplication");
    }

    /**
     * test DotProduct func
     */
    @Test
    void testDotProduct() {

        // ============ Equivalence Partitions Tests ==============

        // TC01: Orthogonal vectors dot product doesn't equal zero
        assertTrue(isZero(v1.dotProduct(v3)),"dotProduct() for orthogonal vectors is not zero");

        // TC02: Wrong vectors dot product calculations
        assertTrue(isZero(v1.dotProduct(v2) + 28),"dotProduct() wrong value");
    }

    /**
     * test CrossProduct func
     */
    @Test
    public void testCrossProduct() {

        // ============ Equivalence Partitions Tests ==============

        Vector vr = v1.crossProduct(v3);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals(v1.length() * v3.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v3)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================

        // TC11: test zero vector from cross-productof co-lined vectors
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v2),"crossProduct() for parallel vectors does not throw an exception");
    }

    /**
     * test LengthSquared func
     */
    @Test
    void testLengthSquared() {

        // ============ Equivalence Partitions Tests ==============

        // TC01: squared length wrong calculation
        assertTrue(isZero(v1.lengthSquared() - 14),"lengthSquared() wrong value");
    }

    /**
     * test Length func
     */
    @Test
    void testLength() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: length wrong calculation
        assertTrue(isZero(new Vector(0, 3, 4).length() - 5), "length() wrong value");
    }

    /**
     * test Normalize func
     */
    @Test
    void testNormalize() {
        Vector u = v1.normalize();

        // ============ Equivalence Partitions Tests ==============
        // TC01: normalized() doesn't creates a new vector (but it should)
        assertFalse( u == v1, "normalized() function does not create a new vector");

        // TC02:  normalize() doesn't make it a unit vector
        assertTrue(isZero(u.length() - 1), "normalize() result is not a unit vector");

        // TC03:  normalize() doesn't make it a unit vector
        double num = Math.sqrt(14);
        assertEquals(new Vector(1/num,2/num,3/num), u,"normalize() result is not a unit vector");
    }
}