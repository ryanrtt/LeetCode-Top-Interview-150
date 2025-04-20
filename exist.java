/* LeetCode 79. Word Search */

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && search(board, r, c, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, int row, int column, String word, int idx) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return false;
        if (board[row][column] == '-') return false;

        if (board[row][column] != word.charAt(idx)) return false; 

        if (idx == word.length() - 1) return true;

        Character temp = board[row][column];
        board[row][column] = '-';

        idx++;

        boolean found = search(board, row + 1, column, word, idx) || search(board, row - 1, column, word, idx) || search(board, row, column + 1, word, idx) || search(board, row, column - 1, word, idx);

        board[row][column] = temp;

        return found;
    }
}