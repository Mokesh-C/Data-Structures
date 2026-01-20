package Backtracking;

public class PathWithMaxGold {
    public static void main(String[] args) {
        int[][] grid = {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        };
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxGold = Math.max(maxGold, getMaxGold(grid, i, j));
            }
        }
        System.out.println("Maximum Gold Collected: " + maxGold);
    }

    private static int getMaxGold(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;
        int gold = grid[row][col];
        grid[row][col] = 0; // mark as visited
        int first = Math.max(getMaxGold(grid, row + 1, col), getMaxGold(grid, row - 1, col)); // down and up
        int second = Math.max(getMaxGold(grid, row, col + 1), getMaxGold(grid, row, col - 1)); // right and left
        grid[row][col] = gold; // backtrack
        return gold + Math.max(first, second);
    }
}
