package bitManipulation;

public class singleNumber {

    //every number is repeating 2 times except one number is repeating once
    public static int singleNumber1(int[] arr){
        int result = 0;
        for(int i=0;i<arr.length;i++){
            result ^=  arr[i];
        }
        return result;
    }

    //every number is repeating 3 times except one number is repeating once
    public static int singleNumber2(int[] arr){
        int result = 0;
        for(int bitIndex = 0;bitIndex<32;bitIndex++){
            int count = 0;
            for(int i=0;i<arr.length;i++){
                if((arr[i] & (1<<bitIndex)) != 0){
                    count++;
                }
            }
            if(count % 3 == 1){
                result |= (1<<bitIndex);
            }
        }

         return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,8,1,5,1,5,2};
        int[] arr2 = {2,5,2,2,5,6,5,1,6,6};
        System.out.println("Single number is: " + singleNumber1(arr));
        System.out.println("Single number is: "+ singleNumber2(arr2));
    }
}

