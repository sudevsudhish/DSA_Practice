package bitManipulation;

import java.util.Scanner;

public class powerOf2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n= sc.nextInt();

        if((n & (n - 1)) == 0)
            System.out.println(n + " is a power of 2");
        else
            System.out.println(n + " is not a power of 2");
    }
}
