package EqualsAndHashCode;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Rectangle("myrect1", 10, 20);
        Shape shape2 = new Sphere("sphere2", 20);
        Shape[]shapes = new Rectangle[10];


//        shapes[0] = new Sphere(1)

        ;
        System.out.println(sumArea(shape1, shape2));

    }


    private static double sumArea(Shape shape1, Shape shape2){
        if(shape1 instanceof Shape3D){
            System.out.printf("volume1=%f\n", ((Shape3D)shape1).volume());
        }
        if(shape2 instanceof Shape3D){
            System.out.printf("%s volume2=%f\n",shape2.getName(), (((Shape3D)shape2).volume()));
        }
        return shape1.area() + shape2.area();
    }
}

