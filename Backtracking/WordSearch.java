package Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(wordExist(board, word, i, j)) {
                    System.out.println("Word found!");
                    return;
                }
            }
        }
        System.out.println("Word not found!");
    }

    private static boolean wordExist(char[][] board, String word, int row, int col) {
        if(word.isEmpty()) return true;
        char ch = word.charAt(0);
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != ch) return false;
        board[row][col] = '.';
        boolean search = wordExist(board, word.substring(1), row + 1, col) ||
                wordExist(board, word.substring(1), row - 1, col) ||
                wordExist(board, word.substring(1), row , col +1) ||
                wordExist(board, word.substring(1), row , col-1);;
        board[row][col] = ch;
        return search;
    }
}
