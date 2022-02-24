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

    public Vector getNormal(Point p){

    }
}
