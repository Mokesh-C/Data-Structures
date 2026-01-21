package Backtracking;

public class UniquePath {
    public static void main(String[] args) {
        int n = 3, m = 7;
        System.out.println("Total Unique Paths in a " + n + "x" + m + " grid: " + uniquePaths(new int[m][n], m-1, n-1));
    }

    private static int uniquePaths(int[][] dp, int m, int n) {
        if(m == 0 || n == 0) return 1;
        if(dp[m][n] != 0) return dp[m][n];
        dp[m][n] = uniquePaths(dp,m-1, n) + uniquePaths(dp, m, n-1);
        return dp[m][n];
    }
}
