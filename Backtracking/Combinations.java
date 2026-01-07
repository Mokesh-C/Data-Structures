package Backtracking;

import java.util.ArrayList;

public class Combinations {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4, k = 3;
        combinations(new ArrayList<>(), 1, n, k);
        System.out.println(ans);
    }
    public static void combinations(ArrayList<Integer> list, int start, int n, int k){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=n && list.size() + (n-i+1) >= k; i++){ // pruning to avoid unnecessary calls, we can use this  i<=n-(k-list.size())+1 also
            list.add(i);
            combinations(list, i+1, n, k);
            list.removeLast();
        }
    }
}
