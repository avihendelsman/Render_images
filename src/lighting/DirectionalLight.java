package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * DirectionalLight
 */
public class DirectionalLight extends Light implements LightSource{
    private Vector direction;

    /**
     *
     * @param intensity
     * @param dir
     */
    public DirectionalLight(Color intensity, Vector dir) {
        super(intensity);
        direction = dir;
    }

    @Override
    public Color getIntensity(Point p){
        return getIntensity();
    }

    @Override
    public Vector getL(Point p){
        return direction.normalize();
    }
}
