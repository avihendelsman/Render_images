package geometries;

import primitives.*;

import java.util.List;

/**
 *  The class defines a geometries type - "Tube".
 */
public class Tube extends Geometry{
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

    @Override
    public Vector getNormal(Point p){
        double t = (axisRay.getDir()).dotProduct(p.subtract(axisRay.getP0()));
        if (t != 0) //in case the point is not across the ray point
        {
            Point center = axisRay.getP0().add(axisRay.getDir().scale(t));
            return p.subtract(center).normalize();
        }
        else // in case the point is across the ray point
            return p.subtract(axisRay.getP0()).normalize();
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray){
        return null;
    }

    @Override
    public String toString(){
        return "Ray is: " + axisRay + "\nradius is: " + radius;
    }
}
