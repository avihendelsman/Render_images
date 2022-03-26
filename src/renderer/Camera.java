package renderer;

import primitives.*;

import static primitives.Util.*;

public class Camera {
    private Point p0;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double height;
    private double width;
    private double distance;

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
        //this.vRight = vUp.crossProduct(vTo).normalize();
        this.vRight = vTo.crossProduct(vUp).normalize();
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

        if (nX % 2 == 0 || nY % 2 == 0) {    // In case the number of columns or rows is even, it moves the Pceneter to the (0,0) pixel
            pC = new Point(pC.getX() - Rx / 2, pC.getY() - Ry / 2, pC.getZ());
        }

        // Pixel[i,j] center
        double yi = alignZero(-(i - (nY - 1) / 2) * Ry);
        double xj = alignZero((j - (nX - 1) / 2) * Rx);

        Point pIJ = pC;

        // To avoid a zero vector exception
        if (xj != 0)
            pIJ = pIJ.add(vRight.scale(xj));
        if (yi != 0)
            pIJ = pIJ.add(vUp.scale(yi));

        Vector vIJ = pIJ.subtract(this.p0);
        return new Ray(p0, vIJ);
    }
}
