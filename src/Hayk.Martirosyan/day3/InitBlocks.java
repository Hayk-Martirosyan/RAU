package day3;

public class InitBlocks {
    {
        System.out.println(1);
        x = 10;
    }
    private int x = getValue();

    {
        System.out.println(3);
        x = 30;
    }

    public static int getValue(){
        System.out.println(2);
        return 20;
    }

    public static void main(String[] args) {
        InitBlocks obj = new InitBlocks();
        System.out.println(obj.x);
    }


    static {
        System.out.println("?");
    }
}
