package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> geometriesBodies;

    /**
     * Empty ctor
     */
    public Geometries() {
        geometriesBodies = new LinkedList<>();
    }

    /**
     * Ctor with list of geometries
     * @param geometries
     */
    public Geometries(Intersectable... geometries)
    {
        geometriesBodies = List.of(geometries);
    }

    /**
     * Adds list of geometries to the current list
     * @param geometries
     */
    public void add(Intersectable... geometries)
    {
        geometriesBodies.addAll(List.of(geometries));
    }


    @Override
    public List<Point> findIntsersections(Ray ray){
        if (geometriesBodies.isEmpty()) // In case the collection is empty
            return null;

        List<Point> points = null, result;
        for (Intersectable body: geometriesBodies) {
            result = body.findIntsersections(ray);
            if(result != null){
                if(points == null)
                    points = new LinkedList<Point>(result);
                else
                    points.addAll(result);
            }
        }
        return points;
    }
}
