package primitives;

public class Vector extends Point {
    public Vector(double x, double y, double z){
        super(x,y,z);
    }

    public Vector add(Vector v2){
        Double3 temp = xyz.add(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3,);
    }

    public Vector subtract(Vector v2){
        Double3 temp = xyz.subtract(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3,);
    }
}
