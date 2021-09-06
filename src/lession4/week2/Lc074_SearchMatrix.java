package lession4.week2;

/**
 * 74. 搜索二维矩阵
 */
public class Lc074_SearchMatrix {
    /**
     * 二分
     * 顺序的数组，可以从数组的 左下角 或者 右上角 为起点搜素，该结构类似二分法。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = rows - 1;
        int column = 0;
        while (row >= 0 && column < columns) {
            int pos = matrix[row][column];
            if (pos == target) return true;
                //该题在 row-- column ++ 取错了值，导致耗费较多时间！！！
            else if (pos > target) row--;
            else column++;
        }
        return false;
    }
}
