package geometries;

import primitives.*;

/**
 * Interface for general geometric obj.
 */
public abstract class Geometry extends Intersectable {

    protected Color emission = Color.BLACK;

    /**
     *
     * @return emission
     */
    public Color getEmission(){
        return emission;
    }

    /**
     *
     * @return emission
     */
    public Geometry setEmission(Color emission){
        this.emission = emission;
        return this;
    }

    /**
     * abstract func who return the normal vector of obj.
     * @param p point p
     * @return the normal vector of obj.
     */
    public abstract Vector getNormal(Point p);
}
