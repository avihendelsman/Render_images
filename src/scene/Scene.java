package scene;

import primitives.*;
import lighting.*;
import geometries.*;

public class Scene {

    public String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = new AmbientLight();
    public Geometries geometries;

    /**
     * @param name
     * Ctor sets up the name and creates an empty collection of geometries
     */
    public Scene(String name) {
        this.name = name;
        geometries = new Geometries();
    }

    /**
     * @param background
     * @return The scene object (this)
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     *
     * @param ambientLight
     * @return The scene object (this)
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     *
     * @param geo
     * @return The scene object (this)
     */
    public Scene setGeometries(Geometries geo) {
        this.geometries = geo;
        return this;
    }

}
