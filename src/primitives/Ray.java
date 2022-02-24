package primitives;

public class Ray {
private final Point p0;
private final Vector dir;
    public Ray(Point po,Vector vec) {
        p0 = po;
        dir = vec.normalize();
    }
}
