package primitives;

import geometries.Intersectable;

import java.util.List;
import geometries.Intersectable.GeoPoint;

import static primitives.Util.alignZero;

/**
 * The class defines a primitive type - "Ray".
 */
public class Ray {
    private final Point p0;
    private final Vector dir;

    private static final double DELTA = 0.1;

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
     * Constructor calculate the movement normal by delta
     * @param vecDir
     * @param p
     * @param n
     */
    public Ray(Vector vecDir, Point p , Vector n) {
        dir = vecDir;
        Vector delta = n.scale(alignZero(n.dotProduct(dir) > 0 ? DELTA : -DELTA));
        p0 = p.add(delta);
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
     * @return The closest point to the began of the ray
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
    }

    /**
     *
     * @param geoPoints
     * @return The closest point to the began of the ray
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> geoPoints) {

        if (geoPoints == null) //In case of an empty list
            return null;
        GeoPoint closePoint = geoPoints.get(0);	//Save the first point in the list
        for (GeoPoint p : geoPoints) {
            if (closePoint.point.distance(p0) > p.point.distance(p0))	//In case the distance of closes point is bigger than the p point
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
