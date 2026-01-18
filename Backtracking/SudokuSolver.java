package Backtracking;

import java.util.Arrays;


public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board, 0, 0);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static boolean solveSudoku(char[][] board, int row, int col) {
        if(col == board.length){
            row = row + 1;
            col = 0;
        }
        if(row == board.length) return true;
        if(board[row][col] != '.') {
            return solveSudoku(board, row, col + 1);
        }
        for(int i = 1; i < 10; i++){
            char ch = (char) (i + '0');
            if(isSafe(board, row, col, ch)){
                board[row][col] = ch;
                if(solveSudoku(board, row, col + 1)) return true;
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, char ch) {
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == ch) return false; // check row
            if(board[i][col] == ch) return false; // check column
//            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return false; // check 3x3 grid
        }
        int r = 3 * (row / 3);
        int c = 3 * (col / 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[r + i][c + j] == ch) return false;
            }
        }
        return true;
    }
}
