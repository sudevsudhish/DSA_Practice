package sorting;

public class insertionSort {
    public static void sort(int[] arr,int n){
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j] >key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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
