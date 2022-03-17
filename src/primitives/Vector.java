package primitives;

import static primitives.Double3.ZERO;

/**
 * The class defines a primitive type - "Vector".
 */
public class Vector extends Point {

    /**
     * A ctor that gets 3 parameters(double type).
     * And further verifies that the vector is not the 0 vector.
     * @param x coordinate x.
     * @param y coordinate y.
     * @param z coordinate z.
     */
    public Vector(double x, double y, double z){
        super(x,y,z);
        if(xyz.equals(ZERO)){
            throw new IllegalArgumentException("vector zero are not allowed");
        }
    }

    /**
     * A ctor that gets 1 parameter(Double3 type).
     * And further verifies that the vector is not the 0 vector.
     * @param xyz
     */
    public Vector(Double3 xyz){
        super(xyz);
        if(xyz.equals(ZERO)){
            throw new IllegalArgumentException("vector zero are not allowed");
        }
    }

    /**
     *  Adding between vectors.
     * @param v2 vector v2
     * @return new Vector.
     */
    public Vector add(Vector v2){
        return new Vector(xyz.add(v2.xyz));
    }

    /**
     * The function calculates vector multiplication by number.
     * @param scalar
     * @return new vector multiplication by number
     */
    public Vector scale(double scalar){
        return new Vector(xyz.scale(scalar));
    }

    /**
     * The function calculates a scalar product.
     * @param v2 vector v2
     * @return scalar.
     */
    public double dotProduct(Vector v2){
        Double3 temp = xyz.product(v2.xyz);
        return temp.d1 + temp.d2 + temp.d3;
    }

    /**
     * The function calculates a vector product.
     * @param v2 vector v2
     * @return vector.
     */
    public Vector crossProduct(Vector v2){
        return new Vector(new Double3((xyz.d2 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d2),
                - ((xyz.d1 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d1)),
                (xyz.d1 * v2.xyz.d2) - (xyz.d2 * v2.xyz.d1)));
    }

    /**
     * the func calc the length sqrt of vector.
     * @return double length of vector.
     */
    public double lengthSquared(){
        return (xyz.d1 * xyz.d1 + xyz.d2 * xyz.d2 + xyz.d3 * xyz.d3);
    }

    /**
     * the func calc the length of vector.
     * @return double length of vector.
     */
    public double length(){
        return Math.sqrt(lengthSquared());
    }

    /**
     * The function normalizes the vector.
     * @return normal vector.
     */
    public Vector normalize(){
        return (scale(1/length()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        return super.equals(obj);
    }

    @Override
    public String toString(){
        return "The vector is: " + xyz;
    }
}
