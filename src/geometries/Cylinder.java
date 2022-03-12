package geometries;

import primitives.*;

import java.util.List;

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

    @Override
    public Vector getNormal(Point p){
        Vector dir = axisRay.getDir();
        Point p0 = axisRay.getP0();
        try {
            var t = dir.dotProduct(p.subtract(p0));
            if (Util.isZero(t) || Util.isZero(t - height))
                return dir;
            var o = p0.add(dir.scale(t));
            return p.subtract(o).normalize();
        } catch (Exception e) {
            return dir;
        }
    }

    @Override
    public List<Point> findIntsersections(Ray ray) {
        return null;
    }

    @Override
    public String toString(){
        return super.toString() + "\nradius is: " + radius;
    }
}
