package geometries;

import primitives.*;

/**
 * The class defines a geometries type - "Plane".
 */
public class Plane implements Geometry{
    private Point p0;
    private Vector normal;

    /**
     * A ctor that gets 2 parameters(Point type and Vector type).
     * @param p
     * @param vec
     */
    public Plane(Point p, Vector vec){
        p0 = p;
        normal = vec.normalize();
    }

    /**
     * A ctor that gets 3 parameters(Point type).
     * @param p1 point p1
     * @param p2 point p2
     * @param p3 point p3
     */
    public Plane(Point p1, Point p2, Point p3){

        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1))
            throw new IllegalArgumentException("Two of the points are the same point");

        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

        try{
            Vector cross = v1.crossProduct(v2);

            p0 = p2;
            normal = cross.normalize();
        }
        catch (Exception e){
            throw new IllegalArgumentException("The points are on the same line");
        }
    }

    /**
     * the func get the field p0.
     * @return p0.
     */
    public Point getP0(){
        return p0;
    }

    /**
     * the func get the field normal.
     * @return normal.
     */
    public Vector getNormal(){
        return normal;
    }

    /**
     * the func implements getNormal method.
     * @param p
     * @return null;
     */
    @Override
    public Vector getNormal(Point p){
        return normal;
    }

    @Override
    public String toString(){
        return "Point is: " + p0 + "\nVector is: " + normal;
    }
}
