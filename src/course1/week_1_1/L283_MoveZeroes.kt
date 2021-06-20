package course1.week_1_1

object L283_MoveZeroes {

    /**
     * 283. 移动零
     */
    fun moveZeroes(nums: IntArray): Unit {
        var k = 0
        var index = 0
        while (index < nums.size) {
            if (nums[index] != 0) {
                nums[k++] = nums[index]
            }
            index++
        }
        for (i in k until nums.size) {
            nums[i] = 0
        }
    }
}