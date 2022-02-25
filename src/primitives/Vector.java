package primitives;

import static primitives.Double3.ZERO;

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
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

    public Vector subtract(Vector v2){
        Double3 temp = xyz.subtract(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

    public Vector scale(double scalar){
        Double3 temp =xyz.scale(scalar);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

    /**
     *
     *
     * @param v2
     * @return
     */
    public double dotProduct(Vector v2){
        Double3 temp = xyz.product(v2.xyz);
        return temp.d1+ temp.d2+ temp.d3 ;
    }
    /**
     *
     * @param v2
     * @return
     */
    public Vector crossProduct(Vector v2){
        Double3 temp = new Double3((xyz.d2 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d2),
                - ((xyz.d1 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d1)),
                (xyz.d1 * v2.xyz.d2) - (xyz.d2 * v2.xyz.d1));
        return new Vector(temp);
    }
    /**
     * the func will calc the length sqrt
     * @return double length
     */
    public double lengthSquared(){
        return (xyz.d1*xyz.d1+xyz.d2*xyz.d2+xyz.d3*xyz.d3);
    }
    /**
     * the func will calc the length sqrt
     * @return double length
     */
    public double length(){
        return Math.sqrt(lengthSquared());
    }

    /**
     *
     * return the normal vactor
     * @return
     */
    public Vector normalize(){
        return (scale(1/length()));
    }

}
