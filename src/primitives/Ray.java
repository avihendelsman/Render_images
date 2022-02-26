package primitives;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray other = (Ray)obj;
        return p0.equals(other.p0) && dir.equals(other.dir);
    }

    @Override
    public String toString(){
        return "Ray: " + "/\nthe Point is: " + p0 + "\nthe normal vector is: " + dir;
    }
}
