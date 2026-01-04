package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4}; // unstable sort
        cyclicSort(arr); // works only when elements are in the range 1 to n where n is the size of the array
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length){
            if(arr[i] != i+1){
                swap(arr, i, arr[i]-1);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
