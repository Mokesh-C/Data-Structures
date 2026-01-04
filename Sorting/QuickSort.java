package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length -1); // unstable sort : does not retain the relative order of equal elements
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = arr[start + (end - start) / 2];
        while(left <= right){
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
