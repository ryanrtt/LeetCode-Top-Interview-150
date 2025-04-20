/* LeetCode 73. Set Matrix Zeroes */

class Solution {
    public void setZeroes(int[][] matrix) {
        int maxRows = matrix.length;
        int maxColumns = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i : rows) {
            setRow(matrix, i, maxColumns);
        }

        for (int i : columns) {
            setColumn(matrix, i, maxRows);
        }
    }

    private void setRow(int[][] matrix, int row, int maxColumns) {
        for (int i = 0; i < maxColumns; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColumn(int[][] matrix, int column, int maxRows) {
        for (int i = 0; i < maxRows; i++) {
            matrix[i][column] = 0;
        }
    }
}