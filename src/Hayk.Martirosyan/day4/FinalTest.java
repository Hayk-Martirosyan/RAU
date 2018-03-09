package day4;

public class FinalTest {
    private final String name;

    private static final double PI;

    FinalTest(){
//        name="";
    }

    FinalTest(String name){
//        this.name = name;
    }

    FinalTest(int someValue){
        this();
//        this.name = "";
    }


    {
        this.name = "";
//        this.PI = Math.PI;
    }

    {
//        this.name = "test";
//        FinalTest.PI = 0;
    }

    static{
//        this.name = "";
//        PI = Math.PI;
        PI = 0;
    }

}
