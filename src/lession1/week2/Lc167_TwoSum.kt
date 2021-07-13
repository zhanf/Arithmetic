package lession1.week2

object Lc167_TwoSum {

    /**
     * 167. 两数之和 II - 输入有序数组
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return nums
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            val sum = nums[i] + nums[j]
            when {
                sum == target -> {
                    return intArrayOf(i + 1, j + 1)
                }
                sum < target -> {
                    i++
                }
                else -> {
                    j--
                }
            }
        }
        return IntArray(0)
    }
}