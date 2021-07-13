package lession1.week2

object Lc304_NumMatrix {
    /**
     * 304. 二维区域和检索 - 矩阵不可变
     */
    class NumMatrix(matrix: Array<IntArray>) {

        private val matrix = matrix
        val sumMatrix = Array(matrix.size, { IntArray(matrix[0].size) })

        init {
            for (i in 0 until sumMatrix.size) {
                for (j in 0 until sumMatrix[i].size) {
                    sumMatrix[i][j] = getSum(i - 1, j) + getSum(i, j - 1) - getSum(i - 1, j - 1) + matrix[i][j]
                }
            }
        }

        fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
            return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1)
        }

        fun getSum(i: Int, j: Int): Int {
            if (i >= 0 && j >= 0) {
                return sumMatrix[i][j]
            }
            return 0
        }
    }
}