package bitManipulation;

import java.util.Scanner;

public class minBitFlipsToConverNumber {
    
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start: ");
        int start = sc.nextInt();
        System.out.println("Enter the goal: ");
        int goal = sc.nextInt();
        int count =0;
        int ans = start ^ goal;
        for(int i=0; i<32;i++){
            if((ans & (1 << i))!=0){
                count++;
            }
        }
        System.out.println("The min bit flips to convert "+start+" to "+ goal + " is " + count);
        
    }
}
