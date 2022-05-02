package lighting;

import primitives.Color;
import primitives.*;

import static primitives.Util.alignZero;

/**
 * class SpotLight
 */
public class SpotLight extends PointLight{
    // the direction of this spot
    private Vector direction;

    // the hwo narrow the beam will be
    double beam = 1;

    /**
     *
     * @param intensity
     * @param position
     * @param dir
     * @param c
     * @param l
     * @param q
     */
    public SpotLight(Color intensity, Point position, Vector dir, double c, double l, double q) {
        super(intensity, position, c, l, q);
        direction = dir.normalize();
    }

    /**
     * @param beam the beam to set
     */
    public SpotLight setNarrowBeam(double beam) {
        this.beam = beam;
        return this;
    }

    @Override
    public Color getIntensity(Point p) {
        double cos = alignZero(getL(p).dotProduct(direction));
        if (cos <= 0)
            return Color.BLACK;
        return super.getIntensity(p).scale(Math.pow(cos, beam));
    }

    @Override
    public Vector getL(Point p) {
        return super.getL(p);
    }
}
