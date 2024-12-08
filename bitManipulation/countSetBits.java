package bitManipulation;
import java.util.Scanner;

public class countSetBits {
    
    @SuppressWarnings("resource")
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int count= 0;
        while(n>1){
            count += n&1;
            n = n>>1;
        }
        if(n == 1){
            count++;
        }
        System.out.println("The number of set bits is: "+ count);
    }
}
