package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11, 5, 78, 3};
        selectionSort(arr1); // unstable sort : does not retain the relative order of equal elements
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {5, 28, 82, 48, 95, 51, 21, 7};
        recursiveSelectionSort(arr2, 0, 1, 0);
        System.out.println(Arrays.toString(arr2));
    }

    private static void recursiveSelectionSort(int[] arr, int i, int j, int minIndex) {
        if(i == arr.length-1) return;
        if(j < arr.length){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
            recursiveSelectionSort(arr, i, j+1, minIndex);
        } else {
            swap(arr, i, minIndex);
            recursiveSelectionSort(arr, i+1, i+2, i+1);
        }
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i< arr.length -1; i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
