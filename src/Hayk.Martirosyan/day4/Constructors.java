package day4;

public class Constructors {
    private String name;
    private int age;

    public Constructors(){
        this.age = 20;

    }

    public Constructors(String name, int age){


        this();
        this.name = name;
        age = 20;
    }

    @Override
    public String toString() {
        return String.format("'%s', %d", this.name, this.age);
    }

    public static void main(String[] args) {
        System.out.println();
    }

    protected void finalize() {

    }
}
