package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];
        for(char[] arr : board) Arrays.fill(arr, '.'); // initialize board with '.'

        System.out.println("Number of ways: " + nQueens(board, 0));
    }

    private static int nQueens(char[][] board, int row) {
        if(row == board.length){
            for(char[] arr : board){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int i = 0; i < board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q'; // place queen
                count += nQueens(board, row + 1);
                board[row][i] = '.'; // backtrack
            }
        }
        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for(int i=0; i<row; i++){
            if(board[i][col] != '.') return false; // check column
        }

        int r = row-1, c = col-1;
        while(r >= 0 && c >=0){
            if(board[r--][c--] != '.') return false; // check left diagonal
        }
        r = row-1; c = col+1;
        while(r >=0 && c < board.length){
            if(board[r--][c++] != '.') return false; // check right diagonal
        }
        return true;
    }
}
