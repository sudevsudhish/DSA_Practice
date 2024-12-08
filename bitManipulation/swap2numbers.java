package bitManipulation;
import java.util.Scanner;

public class swap2numbers {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter the second number: ");
        int n2 = sc.nextInt();

        // XOR operation to swap the numbers
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;

        System.out.println("After swapping: ");
        System.out.println("First number: " + n1);
        System.out.println("Second number: " + n2);
        sc.close();
    }

}
