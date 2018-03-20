package overriding_methods;

public class Main {
    public static void main(String[] args) {
        overriding_methods.Shape shape1 = new overriding_methods.Rectangle("myrect1", 10, 20);
        overriding_methods.Shape shape2 = new overriding_methods.Sphere("sphere2", 20);
        overriding_methods.Shape[]shapes = new overriding_methods.Rectangle[10];


//        shapes[0] = new Sphere(1)

        ;
        System.out.println(sumArea(shape1, shape2));



    }


    private static double sumArea(overriding_methods.Shape shape1, overriding_methods.Shape shape2){
        if(shape1 instanceof overriding_methods.Shape3D){
            System.out.printf("volume1=%f\n", ((overriding_methods.Shape3D)shape1).volume());
        }
        if(shape2 instanceof overriding_methods.Shape3D){
            System.out.printf("%s volume2=%f\n",shape2.getName(), (((overriding_methods.Shape3D)shape2).volume()));
        }
        return shape1.area() + shape2.area();
    }
}
