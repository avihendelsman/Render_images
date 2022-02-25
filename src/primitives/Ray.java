package primitives;

public class Ray {
private final Point p0;
private final Vector dir;
    public Ray(Point po,Vector vec) {
        p0 = po;
        dir = vec.normalize();
    }
    public Point getPoint(){
        return p0;
    }
    public Vector getVector() {
        return dir;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray other = (Ray)obj;
        return this.p0.equals(other.p0)&& this.dir.equals(other.dir);
    }
}
