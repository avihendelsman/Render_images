package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries extends Intersectable {
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
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        if (box != null && !box.IsRayHitBox(ray))
            return null;

        if (geometriesBodies.isEmpty())		// In case the collection is empty
            return null;

        List<GeoPoint> result = null, points;

        for (Intersectable geom : geometriesBodies)	// The loop checks intersections for each shape
        {
            points = geom.findGeoIntersectionsHelper(ray);

            if (points != null) 				// In case there are intersections
            {
                if (result == null)  		    // If we only now start to add shape intersections - assigns the points to result
                {
                    result = points;
                }
                else
                    result.addAll(points);
            }
        }
        return result;
    }
    /**
     * Function that create box for each geometry
     */
    public void setGeometriesBoxes() {
        for(Intersectable geo : geometriesBodies) {
            geo.setBox();
        }
    }

    /**
     * Create big box that will contain all of the geometries
     */
    @Override
    public void setBox() {

        setGeometriesBoxes(); //Create box for each geometry

        Intersectable intersecI = geometriesBodies.get(0);
        double maxX = intersecI.box.maxX;
        double maxY = intersecI.box.maxY;
        double maxZ = intersecI.box.maxZ;
        double minX = maxX;
        double minY = maxY;
        double minZ = maxZ;

        for(Intersectable geo : geometriesBodies) {	//For each geometry find the max and min of is box,
            //and create the geometries box

            if (maxX < geo.box.maxX)
                maxX = geo.box.maxX;

            if (maxY < geo.box.maxY)
                maxY = geo.box.maxY;

            if (maxZ < geo.box.maxZ)
                maxZ = geo.box.maxZ;

            if (minX > geo.box.minX)
                minX = geo.box.minX;

            if (minY > geo.box.minY)
                minY = geo.box.minY;

            if (minZ > geo.box.minZ)
                minZ = geo.box.minZ;
        }
        box = new Box(maxX, maxY, maxZ, minX, minY, minZ);
    }

}
