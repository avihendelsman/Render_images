package lighting;

import primitives.*;

/**
 * interface LightSource
 */
public interface LightSource {

    /**
     * getIntensity
     * @param p
     * @return
     */
    public Color getIntensity(Point p);

    /**
     * getL
     * @param p
     * @return
     */
    public Vector getL(Point p);

    /**
     * get Distance
     * @param point
     * @return
     */
    public double getDistance(Point point);
}
