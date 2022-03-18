package geometries;

import primitives.*;

import java.util.List;

/**
 * interface Intersectable
 *
 * @author
 *
 */
public interface Intersectable {

    /**
     * Finds intersections of a ray with geometric object and returns them as list of points
     * @param ray
     *
     * @return List<Point> - list of intersections in geometric object
     */
    public List<Point> findIntsersections(Ray ray);
}
