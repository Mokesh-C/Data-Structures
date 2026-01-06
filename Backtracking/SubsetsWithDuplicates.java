package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithDuplicates {
    public static void main(String[] args) {
        String str = "abcc";
        subsetsWithDuplicates(str);
    }

    private static void subsetsWithDuplicates(String str) {
        ArrayList<String> subsets = new ArrayList<>();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);
        subsets.add("");
        int start = 0;
        for (int i = 0; i < s.length() ; i++) {
            int len = subsets.size();
            int j = (i > 0 && s.charAt(i) == s.charAt(i - 1)) ? start : 0;
            while (j < len){
                subsets.add(subsets.get(j)+ s.charAt(i));
                j++;
            }
            start = len;
        }
        System.out.println(subsets);
    }
}
