/* LeetCode 79. Word Search */

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // If the current character is the first character of the word, and the word is found
                if (board[r][c] == word.charAt(0) && search(board, r, c, word, 0)) return true;
            }
        }

        return false;
    }

    /**
     * Recursively searches if the word is present within the board.
     * 
     * @param board The board to be searched. 
     * @param row The current row index.
     * @param column The current column index.
     * @param word The word to be searched.
     * @param idx The index of the word.
     * @return <code>true</code> if the word has been found, <code>false</code> otherwise.
     */
    private boolean search(char[][] board, int row, int column, String word, int idx) {
        // Out of bounds check
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return false;
        if (board[row][column] == '-') return false;

        // If the current character does not match at the index of the word
        if (board[row][column] != word.charAt(idx)) return false; 

        // If the current index has reached the end of the word
        if (idx == word.length() - 1) return true;
 
        Character temp = board[row][column];

        // To prevent the same character from being checked twice
        board[row][column] = '-';

        // Index of next character to search
        idx++;

        // Check all four directions and see if there is a match in any of them
        boolean found = search(board, row + 1, column, word, idx) || search(board, row - 1, column, word, idx) || search(board, row, column + 1, word, idx) || search(board, row, column - 1, word, idx);

        // Backtracking
        board[row][column] = temp;

        return found;
    }
}