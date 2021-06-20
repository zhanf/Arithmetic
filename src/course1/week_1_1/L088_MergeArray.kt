package course1.week_1_1

object L088_MergeArray {
    /**
     * 88. 合并有序数组
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pos = m + n - 1
        var i = m - 1
        var j = n - 1
        while (pos >= 0) {
            if (i < 0 || (j >= 0 && nums1[i] < nums2[j])) {
                nums1[pos] = nums2[j]
                j--
            } else {
                nums1[pos] = nums1[i]
                i--
            }
            pos--
        }
    }
}