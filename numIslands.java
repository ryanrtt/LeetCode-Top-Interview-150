/* LeetCode 200. Number of Islands */

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (flood(grid, r, c)) islands++;
            }
        }

        return islands;
    }

    private boolean flood(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return false;
        if (grid[row][column] == '0') return false;

        grid[row][column] = '0';

        flood(grid, row + 1, column);
        flood(grid, row - 1, column);
        flood(grid, row, column + 1);
        flood(grid, row, column - 1);

        return true;
    }   
}