
import java.util.List;

import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.DirectionalLight;
import lighting.PointLight;
import lighting.SpotLight;
import org.junit.jupiter.api.Test;
import primitives.*;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.RayTracerBasic;

import scene.Scene;


/**
 * test the all integration of rendering image
 *
 * @author moshe
 *
 */
public class fullImageTest {

    private Scene scene = new Scene("Test scene").setAmbientLight(new AmbientLight(new Color(255, 255, 255), new Double3(0.1)))
            .setBackground(new Color(0, 0, 128));

    @Test
    public void test() {
        Camera camera = new Camera(new Point(150, 0, 410), new Vector(-40, 0, -100), new Vector(0, 1, 0)) //
                .setVPSize(200, 200).setVPDistance(300).setApertureRadius(0.2).setFpDistance(50);
        // Camera camera = new Camera(new Point3D(400, 0, 1010), new Vector(-40, 0,
        // -100), new Vector(0, 1, 0)) //
        // .setVpSize(200, 200).setVpDistance(900);
        // Camera camera = new Camera(new Point3D(0, 410, 0), new Vector(0, -1, 0), new
        // Vector(0, 0, 1)) //
        // .setVpSize(200, 200).setVpDistance(300);

        List<Point> pl = List.of(new Point(150, 100, -50), new Point(150, -100, -50), new Point(-100, 100, -50),
                new Point(-100, -100, -50), new Point(-100, 100, -40), new Point(-100, -100, -40),
                new Point(-100, 100, 200), new Point(-100, -100, 200), new Point(0, -50, 60),
                new Point(-10, -100, 70), new Point(10, -100, 70), new Point(10, -100, 50),
                new Point(-10, -100, 50), new Point(200, -100, -50), new Point(-200, -100, -50),
                new Point(-200, -100, 200), new Point(200, -100, 200));

        Material mirror = new Material().setKR(0.7).setKD(0.3).setKS(1).setNShininess(50);
        Color colMirror = new Color(20, 20, 20);
        Material matBasis = new Material().setKR(0.2).setKD(0.3).setKS(0.3).setNShininess(100);
        Color colBasis = new Color(153, 51, 0);
        Color colFlooer = new Color(163, 53, 164);
        Material matFloor = new Material().setKR(.1).setKD(0.5).setKS(0.5).setNShininess(300);
        Material matSmallSphere = new Material().setKR(0.05).setKD(0.1).setKS(1).setNShininess(100);
        Material sphereMirror = new Material().setKR(0.4).setKD(0.3).setKS(1).setNShininess(50);

        scene.geometries.add( //
                new Triangle(pl.get(0), pl.get(1), pl.get(2)).setMaterial(mirror).setEmission(colMirror),
                new Triangle(pl.get(1), pl.get(2), pl.get(3)).setMaterial(mirror).setEmission(colMirror),
                new Triangle(pl.get(4), pl.get(6), pl.get(7)).setMaterial(mirror).setEmission(colMirror),
                new Triangle(pl.get(7), pl.get(5), pl.get(4)).setMaterial(mirror).setEmission(colMirror),
                new Triangle(pl.get(13), pl.get(14), pl.get(15)).setEmission(colFlooer).setMaterial(matFloor),
                new Triangle(pl.get(13), pl.get(15), pl.get(16)).setEmission(colFlooer).setMaterial(matFloor),
                new Triangle(pl.get(8), pl.get(9), pl.get(10)).setMaterial(matBasis).setEmission(colBasis),
                new Triangle(pl.get(8), pl.get(10), pl.get(11)).setMaterial(matBasis).setEmission(colBasis),
                new Triangle(pl.get(8), pl.get(11), pl.get(12)).setMaterial(matBasis).setEmission(colBasis),
                new Triangle(pl.get(8), pl.get(12), pl.get(9)).setMaterial(matBasis).setEmission(colBasis),
                new Sphere(new Point(0, 0, 60), 50).setEmission(new Color(30, 30, 30))
                        .setMaterial(new Material().setkT(0.7).setKR(0.1).setKD(0.2).setKS(0.3).setNShininess(50)),
                new Sphere(new Point(-15, -93, 80), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 0, 255)),
                new Sphere(new Point(20, -93, 32), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 255, 255)),
                new Sphere(new Point(-20, -93, 40), 7).setMaterial(matSmallSphere).setEmission(new Color(255, 0, 0)),
                new Sphere(new Point(-23, -93, 90), 7).setMaterial(matSmallSphere)
                        .setEmission(new Color(200, 255, 30)),
                new Sphere(new Point(8, -93, 23), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 255, 0)),
                new Sphere(new Point(90, -93, 21), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 0, 0)),

                new Sphere(new Point(73, -93, 120), 7).setMaterial(matSmallSphere).setEmission(new Color(128, 0, 64)),
                new Sphere(new Point(54, -93, 95), 7).setMaterial(matSmallSphere).setEmission(new Color(255, 50, 128)),
                new Sphere(new Point(24, -93, 104), 7).setMaterial(matSmallSphere).setEmission(new Color(200, 180, 98)),
                new Sphere(new Point(102, -93, 93), 7).setMaterial(matSmallSphere).setEmission(new Color(34, 177, 76)),
                new Sphere(new Point(-70, -93, 105), 7).setMaterial(matSmallSphere).setEmission(new Color(200, 167, 30)),
                new Sphere(new Point(-82, -93, 94), 7).setMaterial(matSmallSphere).setEmission(new Color(20, 154, 76)),


                new Sphere(new Point(0, -41, 60), 7).setMaterial(matSmallSphere).setEmission(new Color(255, 128, 0)),
                new Sphere(new Point(10, -37, 70), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 255, 255)),
                new Sphere(new Point(-20, 23, 27), 7).setMaterial(matSmallSphere).setEmission(new Color(255, 0, 0)),
                new Sphere(new Point(15, 10, 90), 7).setMaterial(matSmallSphere).setEmission(new Color(200, 255, 30)),
                new Sphere(new Point(10, 40, 52), 7).setMaterial(matSmallSphere).setEmission(new Color(0, 255, 0)),
                new Sphere(new Point(-30, -30, 70), 7).setMaterial(matSmallSphere)
                        .setEmission(new Color(128, 255, 128)),
                new Sphere(new Point(20, -14, 92), 7).setMaterial(matSmallSphere).setEmission(new Color(255, 0, 128)),
                new Sphere(new Point(30, 3, 100), 7).setMaterial(matSmallSphere).setEmission(new Color(128, 0, 64)),
                new Sphere(new Point(-24, 23, 40), 7).setMaterial(matSmallSphere)
                        .setEmission(new Color(64, 128, 128)),
                new Sphere(new Point(0, -10, 90), 7).setMaterial(sphereMirror).setEmission(new Color(40, 40, 40))

        );

        scene.lights.add(new DirectionalLight(new Color(300, 300, 300), new Vector(-10, -5, -10)));
        scene.lights.add(new PointLight(new Color(300, 200, 100), new Point(-50, 100, 60),1,0,0).setKL(4E-2).setKQ(2E-8));
        scene.lights.add(new SpotLight(new Color(800, 400, 400), new Point(80, -60, 70), new Vector(-5, -2, -1),1,0,0) //
                .setNarrowBeam(4).setKL(0.001).setKQ(0.0000025));

        camera.setImageWriter(new ImageWriter("fullImageSS1", 500, 500)) //
                //.setRayTracer(new RayTracerSuperSampling(scene, camera, 2))
                .setRayTracer(new RayTracerBasic(scene)) //
                .renderImage(); //
        camera.writeToImage();
    }

    @Test
    public void testFinal() {
        Scene scene = new Scene("Test scene");
        Camera cam = (new Camera(new Point(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, 1, 0)))
                .setVPDistance(1000).setVPSize(200, 200);
        scene.setBackground(new Color(255, 0, 0));
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), new Double3(0.15)));
        scene.geometries.add(
                new Triangle(new Point(1500, 1500, 1500), new Point(-1500, -1500, 1500),
                        new Point(670, -670, -3000)).setEmission(new Color(20, 250, 250))
                        .setMaterial(new Material().setKD(0).setKS(0).setNShininess(0).setkT(0).setKR(1)),
                new Sphere(new Point(0, 0, 50), 50).setEmission(new Color(java.awt.Color.BLUE))
                        .setMaterial(new Material().setKD(0.4).setKS(0.3).setNShininess(100).setkT(0.3)),
                new Sphere(new Point(0, 0, 50), 25).setEmission(new Color(java.awt.Color.RED))
                        .setMaterial(new Material().setKD(0.5).setKS(0.5).setNShininess(100)));
        scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point(60, -50, 0), new Vector(0, 0, 1),1,0,0).setKC(1)
                .setKL(4E-5).setKQ(2E-7));
        scene.lights.add(new DirectionalLight(new Color(500, 300, 0), new Vector(1, -1, 1)));

        ImageWriter imageWriter = new ImageWriter("final test", 600, 600);


        cam.setImageWriter(new ImageWriter("fullImageSS1", 500, 500)) //???????????????
                //.setRayTracer(new RayTracerSuperSampling(scene, camera, 2))
                .setRayTracer(new RayTracerBasic(scene)) //
                .renderImage(); //
        cam.writeToImage();

        /*
          Render render = new Render() //
                .setImageWriter(imageWriter) //
                .setCamera(cam) //
                .setRayTracer(new RayTracerBasic(scene));

        render.renderImage();
        render.writeToImage();
         */

    }

}

