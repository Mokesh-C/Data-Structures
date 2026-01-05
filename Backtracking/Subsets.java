package Backtracking;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        String str = "abc";
        subsets("", str);
        subsetsUsingLoop(str);
    }

    private static void subsetsUsingLoop(String str) {
        ArrayList<String> subsets = new ArrayList<>();
        subsets.add("");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int len = subsets.size();
            for (int j = 0; j < len; j++) {
                subsets.add(subsets.get(j) + ch);
            }
        }
        System.out.println(subsets);
    }

    private static void subsets(String s, String str) {
        if (str.isEmpty()){
            System.out.print(s + " ");
            return;
        }
        char ch = str.charAt(0);
        subsets(s+ch, str.substring(1));
        subsets(s, str.substring(1));
    }
}
