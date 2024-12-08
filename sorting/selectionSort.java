package sorting;


public class selectionSort {
    public static void sort(int[] arr, int n){
        
        for(int i=0;i< n-1;i++){
            int min = i;
            for(int j=i+1;j < n;j++){
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
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
