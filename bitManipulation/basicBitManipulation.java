package bitManipulation;

import java.util.Scanner;

public class basicBitManipulation {
    public static int getbit(int n, int i){
        n = n & (1<<i);
        return n;
    }
    public static int setbit(int n, int i){
        n = n | (1<<i);
        return n;
    }
    public static int clearbit(int n, int i){
        n = n & ~(1<<i);
        return n;
    }
    public static int updatebit(int n, int i){
        if((n | (1<<i)) == 1){
            n = n & ~(1<<i); // update 0 -> 1 
        }else{
            n = n | (1<<i); //update 1 -> 0
        }
        return n;
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Enter the position: ");
        int i = sc.nextInt();
        if(i<=32){
            System.out.println("Get bit: " + getbit(n, i));
            System.out.println("Set bit: " + setbit(n, i));
            System.out.println("Clear bit: " + clearbit(n, i));
            System.out.println("Update bit: " + updatebit(n, i));
        }


    }
}
