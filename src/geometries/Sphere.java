package geometries;

import primitives.*;

import java.util.List;

/**
 * The class defines a geometries type - "Sphere".
 */
public class Sphere implements Geometry{
    private Point center;
    private double radius;

    /**
     * A ctor that gets 2 parameters(Point type and double type).
     */
    public Sphere(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    /**
     * the func get the field center.
     * @return field center.
     */
    public Point getCenter(){
        return center;
    }

    /**
     * the func get the field radius.
     * @return field radius.
     */
    public double getRadius(){
        return radius;
    }

    @Override
    public Vector getNormal(Point p){
        return (p.subtract(center)).normalize();
    }

    @Override
    public List<Point> findIntsersections(Ray ray) {
        return null;
    }

    @Override
    public String toString(){
        return "Point is: " + center + "\nradius is: " + radius;
    }
}
