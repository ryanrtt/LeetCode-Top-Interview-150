/* LeetCode 63. Unique Paths II */

class Solution {
    private class Coordinate {
        public int x, y;

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
            Coordinate coordinate = (Coordinate)o;
            return this.x == coordinate.x && this.y == coordinate.y;
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return walk(obstacleGrid, 0, 0, new HashMap<Coordinate, Integer>());
    }

    private int walk(int[][] grid, int row, int column, HashMap<Coordinate, Integer> hash) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return 0;
        if (grid[row][column] == 1) return 0;
        
        Coordinate coordinate = new Coordinate(row, column);
        if (hash.containsKey(coordinate)) return hash.get(coordinate);

        if (row == grid.length - 1 && column == grid[0].length - 1) return 1;

        int total = walk(grid, row + 1, column, hash) + walk(grid, row, column + 1, hash);
        hash.put(coordinate, total);

        return total;
    }
}