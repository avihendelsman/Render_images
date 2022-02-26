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
        p0 = p2;
        normal = null;
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
    public Vector getNormal(Point p){
        return null;
    }

    @Override
    public String toString(){
        return "Point is: " + p0 + "\nVector is: " + normal;
    }
}
