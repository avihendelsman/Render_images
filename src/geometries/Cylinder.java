package geometries;

import primitives.*;

/**
 *  The class defines a geometries type - "Cylinder".
 */
public class Cylinder extends Tube{
    private double height;

    /**
     *
     * @param axisRay Ray axisRay
     * @param radius double radius
     * @param height double height
     */
    public Cylinder(Ray axisRay, double radius, double height){
        super(axisRay, radius);
        this.height = height;
    }

    /**
     * the func get the field height.
     * @return field height.
     */
    public double getHeight(){
        return height;
    }

    public Vector getNormal(Point p){
        return null;
    }

    @Override
    public String toString(){
        return super.toString() + "\nradius is: " + radius;
    }
}
