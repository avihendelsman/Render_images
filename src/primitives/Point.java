package primitives;

public class Point {
    protected final Double3 xyz;

    public Point(double x, double y, double z){
        xyz = new Double3(x, y, z);
    }

    public Point(Double3 xyz){
        this(xyz.d1, xyz.d2, xyz.d3);
    }

    public Vector subtract(Point p2){
        return new Vector(xyz.subtract(p2.xyz));
    }

    public Point add(Vector v){
        return new Point(xyz.add(v.xyz));
    }

    public double distanceSquared(Point p2){
        return (xyz.d1 - p2.xyz.d1) * (xyz.d1 - p2.xyz.d1) +
                (xyz.d2 - p2.xyz.d2) * (xyz.d2 - p2.xyz.d2) +
                (xyz.d3 - p2.xyz.d3) * (xyz.d3 - p2.xyz.d3);
    }

    public double distance(Point p2){
        return Math.sqrt(distanceSquared(p2));
    }
}
