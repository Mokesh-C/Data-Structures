package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {

        // Combination Sum
        // the same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
        int[] candidates = {2,3,6,7};
        int target = 7;
        Arrays.sort(candidates); // sorting to enable pruning
        combinationSum(new ArrayList<>(), 0, candidates, target);
        System.out.println(ans);
        ans.clear();

        // Combination Sum II
        // each number in candidates may only be used once in the combination. The solution set must not contain duplicate combinations.
        candidates = new int[]{10,1,2,7,6,1,5};
        target = 8;
        Arrays.sort(candidates); // sorting to handle duplicates and enable pruning
        combinationSum2(new ArrayList<>(), 0, candidates, target);
        System.out.println(ans);
        ans.clear();

        // Combination Sum III
        // find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
        int k = 3, n = 9;
        combinationSum3(new ArrayList<>(), 1, k, n);
        System.out.println(ans);
    }

    public static void combinationSum3(ArrayList<Integer> list, int start, int k , int n){
        if(list.size() > k) return;
        if(list.size() == k){
            if(n != 0) return;
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<10; i++){
            if(i>n) break;
            list.add(i);
            combinationSum3(list, i+1, k, n-i);
            list.removeLast();
        }
    }

    public static void combinationSum2(ArrayList<Integer> list, int start, int[] candidates,  int target){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(i!=start && candidates[i-1] == candidates[i]) continue;
            if(candidates[i] > target) break; // pruning to avoid unnecessary calls
            list.add(candidates[i]);
            combinationSum2(list, i+1, candidates, target - candidates[i]);
            list.removeLast();
        }
    }

    public static void combinationSum(ArrayList<Integer> list, int start, int[] candidates, int target){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(candidates[i] > target) break; // pruning to avoid unnecessary calls
            list.add(candidates[i]);
            combinationSum(list, i, candidates, target-candidates[i]);
            list.removeLast();
        }
    }
}
