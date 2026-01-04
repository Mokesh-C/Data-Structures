package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length -1); // stable sort : retains the relative order of equal elements
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= end){
            temp[k++] =arr[j++];
        }

        for(int l=0; l<temp.length; l++){
            arr[start+l] = temp[l];
        }
    }
}
