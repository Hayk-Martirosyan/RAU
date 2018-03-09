package Calculator;

import java.util.Scanner;

/**
 * Calculator
 * @author rharutyunyan
 */

public class Calculator {

    public static void main(String[] args){

        int choice = 0;

        Scanner input1 = new Scanner(System.in);
        while(choice!=1 && choice!=2) {
            System.out.println("For basic operations(+,-,*,/) enter 1\n For operations sin , cos enter 2\n Enter: ");
            choice = input1.nextInt();
        }

        if(choice==1) {
            basicOperations();
        }else{
            trigOperations();
        }

    }
    public static void basicOperations(){
        double a;
        double b;
        double result = 0;
        boolean completed = true;
        String operation;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter with spaces (ex. 4 + 5 ): ");
        a = input.nextInt();
        operation = input.next().toString();
        b = input.nextInt();

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    completed = false;
                } else {
                    result = a / b;
                }
                break;
            default:
                completed = false;
                break;
        }
        if(completed){
            System.out.println(result);
        }
        else{
            System.out.println("Operation can't be completed.");
        }
    }

    public static void trigOperations(){
        String operation1="";
        double x=0;
        double result1=0;
        boolean completed1=true;

        Scanner input = new Scanner(System.in);
        while(!operation1.equals("sin") && !operation1.equals("cos")){
            System.out.println("Enter with spaces(ex. sin 90) : ");

            operation1 = input.next();
            x = input.nextInt();
        }
        switch(operation1){
            case "sin":
                result1 = Math.sin(x);
                break;
            case "cos":
                result1 = Math.cos(x);
                break;
            default:
                completed1=false;
                break;
        }
        if(completed1){
            System.out.println(result1);
        }
        else{
            System.out.println("Operation can't be completed.");
        }
    }
}
