package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Permutation {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        permutation("", str);
        System.out.println();

        int[] arr = {1,2,3};
        permutation(new ArrayList<>(), arr);
        System.out.println(ans);
        ans.clear();
        permutation(arr, 0);
        System.out.println(ans);
        ans.clear();

        int[] nums = {1,1,1,2,3,2,5,5};
        Arrays.sort(nums);
        permutation2(nums, 0);
        System.out.println(ans);

    }

    // T(n) = O(n*n!) because there are n! permutations and to store each permutation it takes O(n) time
    // Without using extra space
    private static void permutation(int[] arr, int index) {
        if(index == arr.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: arr) list.add(num);
            ans.add(list);
            return;
        }
        for(int i=index; i<arr.length; i++){
            if(i != index) swap(arr, index, i);
            permutation(arr, index+1);
            if(i != index) swap(arr, index, i);
        }
    }

    // Using extra space
    public static void permutation(ArrayList<Integer> list, int[] nums){
        if(nums.length == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<=list.size(); i++){
            list.add(i, nums[0]);
            permutation(list, Arrays.copyOfRange(nums, 1, nums.length));
            list.remove(i);
        }
    }

    private static void permutation(String s, String str) {
        if(str.isEmpty()){
            System.out.print(s + " ");
            return;
        }
        for(int i=0; i<=s.length(); i++){
            char ch = str.charAt(0);
            permutation(s.substring(0, i) + ch + s.substring(i), str.substring(1));
        }
    }

    // With duplicates
    public static void permutation2(int[] nums, int index){
        if(index == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums) list.add(num);
            ans.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=index; i<nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            if(nums[i] != nums[index]) swap(nums, i, index);
            permutation2(nums, index+1);
            if(nums[i] != nums[index]) swap(nums, i, index);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
