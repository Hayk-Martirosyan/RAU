package day4;

import java.util.Objects;

public class Base {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Base obj) {
        return Objects.equals(this.name, obj.name);
    }


    public static void main(String[] args) {
        Base a = new Base();
        Base b = new Base();

        Base c = new Child();

        a.setName("abcd");
        b.setName("abcd");
        c.setName("abcd");

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));


    }
}
