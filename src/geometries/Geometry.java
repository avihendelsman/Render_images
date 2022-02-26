package geometries;

import primitives.*;

/**
 * Interface for general geometric obj.
 */
public interface Geometry {

    /**
     * abstract func who return the normal vector of obj.
     * @param p point p
     * @return the normal vector of obj.
     */
    public Vector getNormal(Point p);
}
