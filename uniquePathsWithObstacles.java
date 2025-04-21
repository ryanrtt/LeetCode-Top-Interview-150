/* LeetCode 63. Unique Paths II */

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

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return walk(obstacleGrid, 0, 0, new HashMap<Coordinate, Integer>());
    }

    /**
     * Recursively finds the total number of paths to the end cell. 
     * 
     * @param grid The grid to be traversed.
     * @param row The current row index.
     * @param column The current column index.
     * @param hash Hashmap for memoisation. 
     * @return The number of paths from the starting cell to the end cell.
     */
    private int walk(int[][] grid, int row, int column, HashMap<Coordinate, Integer> hash) {
        // Out of bounds check
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return 0;

        if (grid[row][column] == 1) return 0;
        
        // If the current position has already been calculated, return this value
        Coordinate coordinate = new Coordinate(row, column);
        if (hash.containsKey(coordinate)) return hash.get(coordinate);

        // If the end cell has been reached
        if (row == grid.length - 1 && column == grid[0].length - 1) return 1;

        // Recursively find the total by choosing to move right and down 
        int total = walk(grid, row + 1, column, hash) + walk(grid, row, column + 1, hash);

        // Put calculated value within the hashmap for memoisation
        hash.put(coordinate, total);

        return total;
    }
}