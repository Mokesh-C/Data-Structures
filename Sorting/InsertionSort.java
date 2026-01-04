package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6};
        insertionSort(arr1); // stable sort : retains the relative order of equal elements
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {31, 41, 59, 26, 41, 58};
        recursiveInsertionSort(arr2,1, 1);
        System.out.println(Arrays.toString(arr2));
    }

    private static void recursiveInsertionSort(int[] arr, int i, int j) {
        if(i == arr.length) return;
        if(j > 0 && arr[j] < arr[j-1]){
            swap(arr, j, j-1);
            recursiveInsertionSort(arr, i, j-1);
        } else{
            recursiveInsertionSort(arr, i+1, i+1);
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }

        }
    }

    private static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i], j = i;
            while(j > 0 && val < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
