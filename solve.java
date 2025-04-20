class Solution {
    public class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

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
        HashSet<Coordinate> hash = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == rows - 1 || c == 0 || c == columns - 1) boundary(board, r, c, hash);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
            }
        }

        for (Coordinate coordinate : hash) {
            board[coordinate.y][coordinate.x] = 'O';
        }
    }

    private void boundary(char[][] board, int row, int column, HashSet<Coordinate> hash) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return; 
        if (board[row][column] != 'O') return;

        board[row][column] = 'B';
        hash.add(new Coordinate(column, row));

        boundary(board, row + 1, column, hash);
        boundary(board, row - 1, column, hash);
        boundary(board, row, column - 1, hash);
        boundary(board, row, column + 1, hash);
    }
}