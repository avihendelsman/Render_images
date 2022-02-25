package geometries;

import primitives.*;

public class Plane implements Geometry{
    public Point p0;
    public Vector normal;

    public Plane(Point p, Vector vec){
        p0 = p;
        normal = vec.normalize();
    }

    public Plane(Point p1, Point p2, Point p3){
        p0 = p2;
        normal = null;
    }

    /**
     * the func get p0's field.
     * @return p0.
     */
    public Point getP0(){
        return p0;
    }

    /**
     * the func get normal's field.
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
        return "Point is: " + "p0" + "\nVector is: " + "normal";
    }
}
