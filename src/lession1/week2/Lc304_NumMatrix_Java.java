package lession1.week2;

public class Lc304_NumMatrix_Java {

    private int[][] sum;

    public Lc304_NumMatrix_Java(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i][j] = getSum(i - 1, j) + getSum(i, j - 1) - getSum(i - 1, j - 1) + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
    }

    private int getSum(int i, int j) {
        if (i >= 0 && j >= 0) {
            return sum[i][j];
        }
        return 0;
    }
}
