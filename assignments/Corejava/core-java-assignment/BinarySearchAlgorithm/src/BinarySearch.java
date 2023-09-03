
import java.util.Scanner;

public class BinarySearch {
    static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }
    static int binarySearch(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid; 
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the size");
        int size = scanner.nextInt();
        int arr[]= new int[size];
        System.out.println("enter the array elaments");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("enter the key");
        int key = scanner.nextInt();
        bubbleSort(arr);
        int result = binarySearch(arr, key);
        if (result == -1) {
            System.out.println("Element " + key + " not found in the array.");
        } else {
            System.out.println("Element " + key + " found at index " + result);
        }
    }
}
