package renderer;

import primitives.*;

import java.util.MissingResourceException;

import static primitives.Util.*;

public class Camera {
    private Point p0;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double height;
    private double width;
    private double distance;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracerBase;
    private double focalDistance = 0.0;
    private double apertureRadius = 1.0;
    /**
     * @return the p0
     */
    public Point getP0() {
        return p0;
    }

    /**
     * @return the vUp
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * @return the vTo
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * @return the vRight
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public double getHeigth() {
        return height;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param p0
     * @param vUp
     * @param vTo
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vUp.dotProduct(vTo)))
            throw new IllegalArgumentException("The given vectors are not vertical.");
        this.p0 = p0;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();
        this.vRight = vTo.crossProduct(vUp).normalize();
    }

    /**
     * Calculates the ray that goes through the middle of a pixel i,j on the view
     * plane
     *
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @return The ray that goes through the middle of a pixel i,j on the view plane
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i) {
        // Image center:
        Point pC = p0.add(vTo.scale(this.distance));

        // Ratio:
        double Ry = height / nY;
        double Rx = width / nX;

        // Pixel[i,j] center
        double yi = alignZero(-(i - (nY - 1) / 2.0) * Ry);
        double xj = alignZero((j - (nX - 1) / 2.0) * Rx);

        Point pIJ = pC;

        // To avoid a zero vector exception
        if (xj != 0)
            pIJ = pIJ.add(vRight.scale(xj));
        if (yi != 0)
            pIJ = pIJ.add(vUp.scale(yi));

        Vector vIJ = pIJ.subtract(this.p0);

        return new Ray(p0, vIJ);
    }

    /**
     * A setter for the size of the view plane
     *
     * @param width
     * @param height
     * @return the camera itself
     */
    public Camera setVPSize(double width, double height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width or height cannot be negative!");
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * A setter for the distance of the camera from the view plane
     *
     * @param distance
     * @return the camera itself
     */
    public Camera setVPDistance(double distance) {
        if (distance <= 0)
            throw new IllegalArgumentException("Distance cannot be negative!");
        this.distance = distance;
        return this;
    }

    /**
     * set the iW parm
     */
    public Camera setImageWriter(ImageWriter imageWriter){
        this.imageWriter=imageWriter;
        return this;
    }

    /**
     * set the rayTracerBase parm
     */
    public Camera setRayTracer(RayTracerBase rayTracerBase){
        this.rayTracerBase = rayTracerBase;
        return this;
    }

    /**
     * set Aperture Radius to affect on depth of field
     * (builder design pattern)
     *
     * @param apertureRadius
     * @return this camera object
     */
    public Camera setApertureRadius(double apertureRadius) {
        this.apertureRadius = apertureRadius;
        return this;
    }


    /**
     * set distance of Focal plane from View Plan
     * (builder design pattern)
     *
     * @param focalDistance
     * @return this camera object
     */
    public Camera setFpDistance(double focalDistance) {
        this.focalDistance = focalDistance;
        return this;
    }

    /**
     * get distance of Focal plan from View Plan
     *
     * @return distance from view plan
     */
    public double getFpDistance() {
        return focalDistance;
    }

    /**
     * get radius of Aperture Radius
     *
     * @return radius
     */
    public double getApertureRadius() {
        return apertureRadius;
    }

    /**
     * Method for creating rays and for every ray gets the color for the pixel
     */
    public void renderImage() {
        // In case that not all of the fields are filled
        if (imageWriter == null || rayTracerBase == null)
            throw new MissingResourceException("Missing", "resource", "exception");

        // The nested loop finds and creates a ray for each pixels, finds its color and
        // writes it to the image pixles
        int nY = this.imageWriter.getNy();
        int nX = this.imageWriter.getNx();

        for (int i = 0; i < nX; i++) {
            for (int j = 0; j < nY; j++) {
                imageWriter.writePixel(j, i, castRay(nX, nY, j, i)); // Traces the color of the ray and writes it to the image
            }
        }
    }

    /**
     * The function calculates the ray that hits the pixel and returns the color
     * @return Color
     */
    private Color castRay(int nX, int nY, int j, int i){
        return rayTracerBase.traceRay(constructRayThroughPixel(nX, nY, j, i));
    }

    /**
     * Method for coloring only the grid lines
     *
     * @param interval
     * @param color
     */
    public void printGrid(int interval, Color color) {
        if (imageWriter == null) // In case the image writer is empty
            throw new MissingResourceException("Missing", "resource", "for an imageWriter");
        for (int i = 0; i < imageWriter.getNx(); i++)	// The loop goes through all the pixels
            for (int j = 0; j < imageWriter.getNy(); j++)
                if (i % interval == 0 && i != 0 || j % interval == 0 && j != 0) // In case we are in the grid lines
                    imageWriter.writePixel(i, j, color);
    }

    /**
     * Method for start the "writeToImage()" in imageWriter object
     */
    public void writeToImage() {
        if (imageWriter == null)
            throw new MissingResourceException("Missing", "resource", "for an imageWriter");
        imageWriter.writeToImage();
    }

}
