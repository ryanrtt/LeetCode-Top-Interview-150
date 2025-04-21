/* LeetCode 73. Set Matrix Zeroes */

class Solution {
    public void setZeroes(int[][] matrix) {
        int maxRows = matrix.length;
        int maxColumns = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();

        // Iterates through the grid and records all rows and columns that contain a 0 
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Set each required row to 0
        for (int i : rows) {
            setRow(matrix, i, maxColumns);
        }

        // Set each required column to 0
        for (int i : columns) {
            setColumn(matrix, i, maxRows);
        }
    }

    /**
     * Sets the entire row of the matrix to 0.
     * 
     * @param matrix The matrix to modify.
     * @param row The index of the row to modify.
     * @param maxColumns The number of columns of the matrix.
     */
    private void setRow(int[][] matrix, int row, int maxColumns) {
        for (int i = 0; i < maxColumns; i++) {
            matrix[row][i] = 0;
        }
    }

    /**
     * Sets the entire column of the matrix to 0.
     * 
     * @param matrix The matrix to modify.
     * @param column The index of the column to modify.
     * @param maxRows The number of rows of the matrix. 
     */
    private void setColumn(int[][] matrix, int column, int maxRows) {
        for (int i = 0; i < maxRows; i++) {
            matrix[i][column] = 0;
        }
    }
}