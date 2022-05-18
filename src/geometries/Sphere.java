package geometries;

import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.*;

/**
 * The class defines a geometries type - "Sphere".
 */
public class Sphere extends Geometry{
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
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray){
        if (box != null && !box.IsRayHitBox(ray))
            return null;

        double r = this.radius;
        // Special case: if point p0 == center, that mean that all we need to calculate
        // is the radios mult scalar with the direction, and add p0
        if (center.equals(ray.getP0())) {
            LinkedList<GeoPoint> result = new LinkedList<GeoPoint>();
            result.add(new GeoPoint(this, ray.getPoint(r)));
            return result;
        }

        Vector u = center.subtract(ray.getP0());
        double tm = u.dotProduct(ray.getDir());
        double d = Math.sqrt(alignZero(u.lengthSquared() - tm * tm));

        if (d >= r) //also In case the cut is tangent to the object still return null - d = r
            return null;

        double th = Math.sqrt(r * r - d * d);
        double t1 = tm + th;
        double t2 = tm - th;

        if(alignZero(t1) > 0 || alignZero(t2) > 0){
            LinkedList<GeoPoint> result = new LinkedList<GeoPoint>();
            if(alignZero(t1) > 0){
                Point p1 = ray.getPoint(t1);
                result.add(new GeoPoint(this, p1));
            }
            if(alignZero(t2) > 0){
                Point p2 = ray.getPoint(t2);
                result.add(new GeoPoint(this, p2));
            }
            return result;
        }
        else { //In case there are no intersections points
            return null;
        }
    }

    @Override
    public String toString(){
        return "Point is: " + center + "\nradius is: " + radius;
    }
    /**
     * Create bix for sphere
     */
    @Override
    public void setBox() {
        //Get the max and min for sphere box
        double maxX = center.getX() + radius;
        double maxY = center.getY() + radius;
        double maxZ = center.getZ() + radius;

        double minX = center.getX() - radius;
        double minY = center.getY() - radius;
        double minZ = center.getZ() - radius;

        this.box = new Box(maxX, maxY, maxZ, minX, minY, minZ);
    }
}
