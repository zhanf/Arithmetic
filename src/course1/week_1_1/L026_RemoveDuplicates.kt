package course1.week_1_1

object L026_RemoveDuplicates {
    /**
     * 26. 删除有序数组中的重复项
     */
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        var index = 0
        while(index < nums.size){
            if(index == 0 || nums[index] != nums[index-1]){
                nums[k] = nums[index]
                k++
            }
            index++
        }
        return k
    }
}