package day4;

public class Constructors {
    private String name;
    private int age;

    public Constructors(){
        this.age = 20;

    }

    public Constructors(String name){
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("'%s', %d", this.name, this.age);
    }

    public static void main(String[] args) {
        Constructors c1 = new Constructors();
        System.out.println(c1.toString());

        Constructors c2 = new Constructors("c2");
        System.out.println(c2.toString());

    }

}
