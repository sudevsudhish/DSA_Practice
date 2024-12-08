package sorting;
public class quickSort {
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;  
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            } 
        }
        swap(arr, i + 1, high);
        return i + 1; 
    }

    public static void sort(int[] arr, int low, int high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) 
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 52, 6, 8, 42, 3, 21, 5, 4, 12, 6, 9};
        int n = arr.length;

        sort(arr, 0, n - 1); 
        System.out.println("Sorted array is: ");
        printArray(arr); 
    }
}
