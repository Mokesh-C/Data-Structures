package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 6, 2, 1, 7};
        bubbleSort(arr); // stable sort : retains the relative order of equal elements
        System.out.println("Sorted Ascending : " + Arrays.toString(arr));
        recursiveBubbleSort(arr, 0, 1);
        System.out.println("Sorted Descending : " + Arrays.toString(arr));
    }

    private static void recursiveBubbleSort(int[] arr, int i, int j) {
        if (i == arr.length - 1) return;
        if (j < arr.length - i) {
            if (arr[j - 1] < arr[j]) swap(arr, j - 1, j); // arr[j-1] < arr[j] sort in reverse order
            recursiveBubbleSort(arr, i, j + 1);
        } else {
            recursiveBubbleSort(arr, i + 1, 1);
        }

    }

    private static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) { // arr[j-1] > arr[j] sort in ascending order
                    swap(arr, j - 1, j);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
