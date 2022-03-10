package geometries;

import primitives.*;

/**
 * The class defines a geometries type - "Triangle".
 */
public class Triangle extends Polygon {

    /**
     * A ctor that gets 3 parameters(Point type).
     * @param p1 point p1
     * @param p2 point p2
     * @param p3 point p3
     */
    public Triangle(Point p1, Point p2, Point p3){
        super(p1, p2, p3);
    }

    @Override
    public Vector getNormal(Point p){
        return super.getNormal(p);
    }
}
