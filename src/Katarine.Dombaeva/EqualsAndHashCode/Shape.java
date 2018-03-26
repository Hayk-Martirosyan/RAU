package EqualsAndHashCode;

public abstract class Shape {
    private String name;

    public Shape() {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shape shape = (Shape) o;
        return name.equals(shape.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }
}

abstract class Shape2D extends Shape {

    public Shape2D(String name) {
        super(name);
    }

    public abstract double perimeter();

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


abstract class Shape3D extends Shape {
    public Shape3D(String name) {
        super(name);
    }
    public abstract double volume();

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class Rectangle extends Shape2D {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double perimeter() {
        return 2*(height+width);
    }

    @Override
    public double area() {
        return height+width;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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




