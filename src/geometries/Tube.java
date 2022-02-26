package geometries;

import primitives.*;

/**
 *  The class defines a geometries type - "Tube".
 */
public class Tube implements Geometry{
    protected Ray axisRay;
    protected double radius;

    /**
     * A ctor that gets 2 parameters(Ray type and double type).
     * @param axisRay Ray axisRay
     * @param radius double radius
     */
    public Tube(Ray axisRay, double radius){
        this.axisRay = axisRay;
        this.radius = radius;
    }

    /**
     * the func get the field axisRay.
     * @return field axisRay.
     */
    public Ray getAxisRay(){
        return axisRay;
    }

    /**
     * the func get the field radius.
     * @return field radius.
     */
    public double getRadius(){
        return radius;
    }

    public Vector getNormal(Point p){
        return null;
    }

    @Override
    public String toString(){
        return "Ray is: " + axisRay + "\nradius is: " + radius;
    }
}
