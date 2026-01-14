package Backtracking;

import java.util.Arrays;

public class TilePossibilities {
    public static void main(String[] args) {
        String str = "AAABBC";
        //Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles
        // Leetcode 1079

        // This is a problem combination of permutations and subsets with duplicates
        int count = tilePossibilities(str);
        System.out.println("Tile Possibilities: " + count);

    }

    private static int tilePossibilities(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return possibilities(arr, new boolean[arr.length]);
    }

    private static int possibilities(char[] str, boolean[] visit) {
        int count = 0;
        for(int i=0; i<str.length; i++){
            if(visit[i]) continue;
            if(i>0 && str[i-1] == str[i] && !visit[i-1]) continue;
            visit[i] = true;
            count += 1 + possibilities(str, visit); // count the current character + further possibilities
            visit[i] = false;
        }
        return count;
    }
}
