package primitives;

/**
 * The class defines a primitive type - "Point".
 */
public class Point {
    protected final Double3 xyz;

    /**
     * A ctor that gets 3 parameters(double type).
     * @param x coordinate x.
     * @param y coordinate y.
     * @param z coordinate z.
     */
    public Point(double x, double y, double z){
        xyz = new Double3(x, y, z);
    }

    /**
     * A ctor that gets 1 parameter(Double3 type).
     * @param xyz
     */
    public Point(Double3 xyz){
        this(xyz.d1, xyz.d2, xyz.d3);
    }

    /**
     * get func for coordinate x
     * @return coordinate x
     */
    public double getX(){
        return xyz.d1;
    }

    /**
     * Subtraction between points.
     * @param p2 point p2
     * @return Vector who made as a result of subtracting 2 points.
     */
    public Vector subtract(Point p2){
        return new Vector(xyz.subtract(p2.xyz));
    }

    /**
     * Adding between point and vector.
     * @param v vector v
     * @return point.
     */
    public Point add(Vector v){
        return new Point(xyz.add(v.xyz));
    }

    /**
     * The function calculates the distance between two points in squared.
     * @param p2 point p2
     * @return distance between two points in squared.
     */
    public double distanceSquared(Point p2){
        return (xyz.d1 - p2.xyz.d1) * (xyz.d1 - p2.xyz.d1) +
                (xyz.d2 - p2.xyz.d2) * (xyz.d2 - p2.xyz.d2) +
                (xyz.d3 - p2.xyz.d3) * (xyz.d3 - p2.xyz.d3);
    }

    /**
     * The function calculates the distance between two points.
     * @param p2 Point p2
     * @return distance between two points.
     */
    public double distance(Point p2){
        return Math.sqrt(distanceSquared(p2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point)) return false;
        Point other = (Point)obj;
        return xyz.equals(other.xyz) ;
    }

    @Override
    public String toString(){
        return "The point is: " + xyz;
    }
}

