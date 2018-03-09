package Hanoi;

import java.util.Scanner;

/**
 * Hanoi Tower
 * @author rharutyunyan
 */

public class Hanoi {
    static int count=1;

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int amount;

        System.out.println("Hanoi Tower");
        System.out.println("Enter Tower's Disks amount: ");

        amount = input.nextInt();
        move(amount , "A" , "B" , "C");
    }

    public static void move(int n, String start, String temp, String end){
        if(n==1){
            System.out.println(count + " Move " + start + " to " + end);
            count++;
        }else{
            move(n-1, start, end, temp);
            System.out.println(count + " Move " + start + " to " + end);
            count++;
            move(n-1, temp , start, end);
        }
    }
}
