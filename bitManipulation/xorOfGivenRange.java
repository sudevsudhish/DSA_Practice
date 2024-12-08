package bitManipulation;

import java.util.Scanner;

public class xorOfGivenRange {
    public static int xorRange(int n){
        int result = 0;
        if(n%4 == 1)
            result = 1;
        else if(n%4 == 2)
            result = n+1;
        else if(n%4 == 3)
            result = 0;
        else if(n%4 == 0)
            result = n;

        return result;
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number: ");
        // int n = sc.nextInt();
        // System.out.println("Xor of numbers till "+n+" is "+xorRange(n));

        System.out.println("Enter starting range:");
        int n1 = sc.nextInt();
        System.out.println("Enter ending range:");
        int n2 = sc.nextInt();
        int res = xorRange(n1-1) ^ xorRange(n2);

        System.out.println("The result is: "+res);
        
    }
}
