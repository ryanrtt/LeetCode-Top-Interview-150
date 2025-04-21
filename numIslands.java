/* LeetCode 200. Number of Islands */

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // If the flood fill was successful, this means there was an island
                if (flood(grid, r, c)) islands++;
            }
        }

        return islands;
    }

    /**
     * Flood fills a grid with 0s on an instance of 1. 
     * 
     * @param grid The grid to be filled.
     * @param row The current row.
     * @param column The current column.
     * @return <code>true</code> if the flood fill was successful, <code>false</code> otherwise.
     */
    private boolean flood(char[][] grid, int row, int column) {
        // Out of bounds check 
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return false;

        // If the current cell is already a 0
        if (grid[row][column] == '0') return false;

        // Set the cell to 0
        grid[row][column] = '0';

        // Flood fill in all 4 directions
        flood(grid, row + 1, column);
        flood(grid, row - 1, column);
        flood(grid, row, column + 1);
        flood(grid, row, column - 1);

        return true;
    }   
}