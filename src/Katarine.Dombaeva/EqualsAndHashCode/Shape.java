package EqualsAndHashCode;

import java.util.Objects;

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
        if(o == this) {
            return true;
        }
        if(!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle r = (Rectangle)o;
        return this.height == r.height &&
                this.width == r.width &&
                Objects.equals(this.getName() , r.getName());
    }

    @Override
    public int hashCode() {
        int result = this.getName().hashCode();
        result = 31 * result + Double.hashCode(this.width);
        result = 31 * result + Double.hashCode(this.height);
        return result;
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

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Sphere)) {
            return false;
        }
        Sphere s = (Sphere)o;
        return this.radius == s.radius &&
                Objects.equals(this.getName() , s.getName());
    }

    @Override
    public int hashCode() {
        int result = this.getName().hashCode();
        result = 31 * result + Double.hashCode(this.radius);
        return result;
    }
}




