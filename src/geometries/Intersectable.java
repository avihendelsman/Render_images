package geometries;

import primitives.*;

import java.util.List;

/**
 * interface
 *
 * @author
 *
 */
public interface Intersectable {

    /**
     * Finds intersections of a ray with geometric object and returns them as list of points
     * @param ray
     * @return List<Point> - list of intersections
     */
    public List<Point> findIntsersections(Ray ray);
}
