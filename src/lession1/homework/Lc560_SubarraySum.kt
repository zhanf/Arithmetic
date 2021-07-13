package lession1.homework

object L560_SubarraySum {

    /**
     * 560. 和为K的子数组
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()

        map.entries.forEach{
            it.key
        }
        map.put(0, 1)
        var count = 0
        var pre = 0
        for (num in nums) {
            //pre 为之前数相加得到的和
            pre += num
            if (map.contains(pre - k)) {
                count += map.get(pre - k)!!
            }
            //保存 pre 的值，并把次数+1
            map.put(pre, map.getOrDefault(pre, 0) + 1)
        }
        return count
    }
}

object Mark {}