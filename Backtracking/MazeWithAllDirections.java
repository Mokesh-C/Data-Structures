package Backtracking;

import java.util.Arrays;

public class MazeWithAllDirections {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] visited = new int[n][m];
        System.out.println("All Possible Paths in Maze (All Directions): ");
        mazeAllPaths("", 0, 0, visited, 1);
    }

    private static void mazeAllPaths(String s, int n, int m, int[][] visited, int step) {
        if(n == visited.length - 1 && m == visited[0].length - 1){
            visited[n][m] = step;
            System.out.println(s);
            for(int[] arr : visited){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            visited[n][m] = 0;
            return;
        }
        if(n < 0 || m < 0 || n >= visited.length || m >= visited[0].length || visited[n][m] != 0) return;

        visited[n][m] = step;

        mazeAllPaths(s + "D", n+1, m, visited, step + 1); // down
        mazeAllPaths(s + "R", n, m+1, visited, step + 1); // right
        mazeAllPaths(s + "U", n-1, m, visited, step + 1); // up
        mazeAllPaths(s + "L", n, m-1, visited, step + 1); // left

        visited[n][m] = 0; // backtrack
    }
}
