package Backtracking;

public class UniquePath3 {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        };
        int count = 0, row = 0, col = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != -1) count++;
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("Total Unique Paths: " + uniquePathsIII(grid, new boolean[grid.length][grid[0].length], row, col, count));
    }

    private static int uniquePathsIII(int[][] grid, boolean[][] visited, int row, int col, int count) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1 || visited[row][col]) {
            return 0;
        }
        if(grid[row][col] == 2) {
            count--;
            return count == 0 ? 1 : 0;
        }
        visited[row][col] = true;
        int totalPaths = uniquePathsIII(grid, visited, row + 1, col, count-1) +
                uniquePathsIII(grid, visited, row - 1, col, count-1) +
                uniquePathsIII(grid, visited, row, col + 1, count-1) +
                uniquePathsIII(grid, visited, row, col - 1, count-1);
        visited[row][col] = false;
        return totalPaths;
    }
}
