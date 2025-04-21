/* LeetCode 130. Surrounded Regions */

class Solution {
    /* Class to store each grid slot using its x and y component. */
    public class Coordinate {
        int x, y;

        /**
         * Constructor method to store x and y component.
         * 
         * @param x The current x-coordinate.
         * @param y The current y-coordinate.
         */
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Generates a hash of the coordinate based on its x and y component.
         * 
         * @return A hash of the coordinate based its x and y component.
         */
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        /** 
         * Finds whether two Coordinate objects are equal, if they have the same x and y coordinates.
         * 
         * @param o The object being compared.
         * @return <code>true</code> if the x and y coordinates are the same, <code>false</code> otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Coordinate)) return false;

            Coordinate coordinate = (Coordinate)o;
            return this.x == coordinate.x && this.y == coordinate.y;
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        // Hashset to record all changed cells at the boarder
        HashSet<Coordinate> hash = new HashSet<>();

        // Iterate through entire board and flood fill all instances of 'O' at the border 
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == rows - 1 || c == 0 || c == columns - 1) boundary(board, r, c, hash);
                }
            }
        }

        // Iterate through entire board and change all instances of 'O' to 'X'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
            }
        }

        // Change back all cells filled from the boundary to 'O'
        for (Coordinate coordinate : hash) {
            board[coordinate.y][coordinate.x] = 'O';
        }
    }

    /**
     * Recursively flood-fills all 'O' cells with 'B' from a starting position.
     * 
     * @param board The board to be filled.
     * @param row The current row index.
     * @param column The current column index.
     * @param hash The hashset to add all modified cells to.
     */
    private void boundary(char[][] board, int row, int column, HashSet<Coordinate> hash) {
        // Out of bounds check
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return; 

        if (board[row][column] != 'O') return;

        // Modify the cell and add this position to the hashset
        board[row][column] = 'B';
        hash.add(new Coordinate(column, row));

        // Perform flood fill operation on all four directions
        boundary(board, row + 1, column, hash);
        boundary(board, row - 1, column, hash);
        boundary(board, row, column - 1, hash);
        boundary(board, row, column + 1, hash);
    }
}