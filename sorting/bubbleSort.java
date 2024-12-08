package sorting;

public class bubbleSort {
    public static void sort(int[] arr,int n){
        boolean swapped = false;
        for(int i=0;i<n-1;i++){
            swapped = false;
            for(int j=0;j<n-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {1, 52, 6, 8, 42, 3, 21, 5, 4, 12, 6, 9};
        int n = arr.length;
        sort(arr,n);
        printArray(arr);
    }
}
