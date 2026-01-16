package Backtracking;

public class Maze {
    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println("Possible Path: " + possiblePathCount(n-1, m-1, new int[n][m]));
        System.out.println("All Possible Paths: ");
        possiblePath("", n, m);

        // maze with obstacles
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println("All Possible Paths in Maze with Obstacles: ");
        mazePath("", maze, 0, 0);

    }

    private static void mazePath(String s, boolean[][] maze, int n, int m) {
        if(n == maze.length-1 && m == maze[0].length-1){
            System.out.println(s);
            return;
        }
        if(!maze[n][m]) return; // obstacle found
        if(n < maze.length-1 ) mazePath(s + "D", maze, n+1, m);
        if(m < maze[0].length-1) mazePath(s + "R", maze, n, m+1);
    }

    private static void possiblePath(String s, int n, int m) {
        if(n == 1 && m == 1){
            System.out.println(s);
            return;
        }
        if(n > 1) possiblePath(s + "D", n-1, m);
        if(m > 1) possiblePath(s + "R", n, m-1);
//        if(m > 1 && n > 1) possiblePath(s + "Di", n-1, m-1); // for diagonal moves
    }

    private static int possiblePathCount(int n, int m, int[][] memo) {
        if(n == 0 || m == 0) return 1;
        if(memo[n][m] != 0) return memo[n][m];
        memo[n][m] = possiblePathCount(n-1, m, memo) + possiblePathCount(n, m-1, memo);
        return memo[n][m];
    }
}
