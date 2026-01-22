package Backtracking;

public class UniquePathWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        for(int i=0; i<obstacleGrid.length; i++){
            for(int j=0; j<obstacleGrid[0].length; j++){
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? -1 : -2;
            }
        }
        System.out.println(uniquePath(obstacleGrid, 0, 0));
    }

    private static int uniquePath(int[][] memo, int row, int col) {
        if(row >= memo.length || col >= memo[0].length || memo[row][col] == -2) return 0;
        if(row == memo.length-1 && col == memo[0].length-1) return 1;
        if(memo[row][col] != -1) return memo[row][col];
        memo[row][col] =  uniquePath(memo, row+1, col) + uniquePath(memo, row, col+1);
        return memo[row][col];
    }
}
