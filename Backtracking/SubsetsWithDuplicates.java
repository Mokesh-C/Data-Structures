package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithDuplicates {
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String str = "aaab";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);
        subsetsWithDuplicates(s);
        subsetsWithDuplicates("", s);
        System.out.println(result);
    }

    private static void subsetsWithDuplicates(String s, String str) {
        if(str.isEmpty()){
            result.add(s);
            return;
        }
        subsetsWithDuplicates(s + str.charAt(0), str.substring(1));
        if(!s.isEmpty() && s.charAt(s.length() - 1) == str.charAt(0)){
            return;
        }
        subsetsWithDuplicates(s, str.substring(1));
    }

    private static void subsetsWithDuplicates(String str) {
        ArrayList<String> subsets = new ArrayList<>();
        subsets.add("");
        int start = 0;
        for (int i = 0; i < str.length() ; i++) {
            int len = subsets.size();
            int j = (i > 0 && str.charAt(i) == str.charAt(i - 1)) ? start : 0;
            while (j < len){
                subsets.add(subsets.get(j)+ str.charAt(i));
                j++;
            }
            start = len;
        }
        System.out.println(subsets);
    }
}
