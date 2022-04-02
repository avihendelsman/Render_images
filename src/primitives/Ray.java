package primitives;

import java.util.List;

/**
 * The class defines a primitive type - "Ray".
 */
public class Ray {
    private final Point p0;
    private final Vector dir;

    /**
     * A ctor that gets 2 parameters(Point type and Vector type).
     * @param p point p
     * @param vec vector vec
     */
    public Ray(Point p, Vector vec) {
        p0 = p;
        dir = vec.normalize();
    }

    /**
     * get the field p0.
     * @return point.
     */
    public Point getP0(){
        return p0;
    }

    /**
     * get the field dir.
     * @return vector.
     */
    public Vector getDir() {
        return dir;
    }

    /**
     *
     * @param listPoint
     * @return The closest point to the began of the ray
     */
    public Point findClosestPoint(List<Point> listPoint) {

        if (listPoint == null) //In case of an empty list
            return null;
        Point closePoint = listPoint.get(0);	//Save the first point in the list
        for (Point p : listPoint) {
            if (closePoint.distance(p0) > p.distance(p0))	//In case the distance of closes point is bigger than the p point
                closePoint = p;
        }
        return closePoint;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray other = (Ray)obj;
        return p0.equals(other.p0) && dir.equals(other.dir);
    }

    /**
     * return - cross point with the geometry body by getting the length
     * from the start of the ray
     * @param t length from the start of the ray
     * @return point on the ray by get length from the start of the ray
     *
     */
    public Point getPoint(double t) {
        return getP0().add(getDir().scale(t));
    }

    @Override
    public String toString(){
        return "Ray: " + "/\nthe Point is: " + p0 + "\nthe normal vector is: " + dir;
    }
}
