package primitives;

public class Vector extends Point {
    public Vector(double x, double y, double z){
        super(x,y,z);
        if(xyz.equals(ZERO)){
            throw new IllegalArgumentException("vector zero are not allowed");
        }
    }

    public Vector(Double3 xyz){
        super(xyz);
        if(xyz.equals(ZERO)){
            throw new IllegalArgumentException("vector zero are not allowed");
        }
    }

    public Vector add(Vector v2){
        Double3 temp = xyz.add(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3,);
    }

    public Vector subtract(Vector v2){
        Double3 temp = xyz.subtract(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3,);
    }

    public Vector scale(double scalar){
        Double3 temp =xyz.scale(scalar);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

    public double dotProduct(Vector v2){
        Double3 temp = xyz.product(v2.xyz);
        return temp.d1+ temp.d2+ temp.d3 ;
    }

    public Vector crossProduct(Vector v2){
        Double3 temp = new Double3((xyz.d2 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d2),
                - ((xyz.d1 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d1)),
                (xyz.d1 * v2.xyz.d2) - (xyz.d2 * v2.xyz.d1));
        return new Vector(temp.d1, temp.d2, temp.d3);
    }
}
