package lession1.week2

object Lc053_MaxSubArray {

    /**
     * 53. 最大子序和
     */
    fun maxSubArray(nums: IntArray): Int {
        val intArray = IntArray(4)
        intArrayOf()
        if (nums.isEmpty()) return 0
        var res = nums[0]
        for (i in 1 until nums.size) {
            //前缀和,nums[i-1]为负值则舍弃
            nums[i] = nums[i] + Math.max(nums[i - 1], 0)
            res = Math.max(res, nums[i])
        }
        return res
    }

    fun maxSubArray2(nums: IntArray): Int {
        val sums = IntArray(nums.size + 1)
        sums[0] = 0
        for((i, num) in nums.withIndex()) {
            sums[i+1] = sums[i] + num
        }
        var res = Int.MIN_VALUE
        var preMin = sums[0]
        for(i in 1 until sums.size){
            res = Math.max(res,sums[i] - preMin)
            preMin = Math.min(sums[i],preMin)
        }
        return res
    }
}