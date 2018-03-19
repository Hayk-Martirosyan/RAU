package day6;

public abstract class Shape {
    private String name;

//    public Shape() {
//
//    }

    public Shape(String name) {

        System.out.println(this.name.length());
        this.name = name;
        final int x =0;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public abstract double area();

    public void f(Shape2D s){

    }
}

abstract class Shape2D extends Shape {

    public Shape2D(String name) {
        super(name);
    }

    public abstract double perimeter();


}


abstract class Shape3D extends Shape {
    public Shape3D(String name) {
        super(name);
    }
    public abstract double volume();
}

class Rectangle extends Shape2D {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);

//        setName(name);
        this.width = width;
        this.height = height;
        width *= 2;
    }

    public double perimeter() {
        return 2*(height+width);
    }

    @Override
    public double area() {
        return height+width;
    }

}

final class Sphere extends Shape3D {
    private double radius;

    public Sphere(String name, double radius) {
        super(name);
//        setName(name);

        this.radius = radius;
    }

    @Override
    public double area() {
        return 4*Math.PI *radius*radius;
    }

    @Override
    public double volume() {
        return 4/3*Math.PI * Math.pow(radius, 3);
    }
}



