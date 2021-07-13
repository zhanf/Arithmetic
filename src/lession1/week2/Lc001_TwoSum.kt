package lession1.week2

object Lc001_TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        /**
         * 1. 两数之和
         */
        val map = HashMap<Int, Int>()
        for ((i, num) in nums.withIndex()) {
            val left = target - num
            if (map.containsKey(left)) {
                return intArrayOf(map[left]!!, i)
            }
            map.put(num, i)
        }
        return intArrayOf()
    }
}