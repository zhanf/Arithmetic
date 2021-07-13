package lession1.week2

object Lc1248_NumberOfSubarrays {

    /**
     * 1248. 统计「优美子数组」
     * 前缀和
     * count中，index为前缀和，value为前缀合个数
     */
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val len = nums.size
        val s = IntArray(len + 1)
        val count = IntArray(len + 1)
        count[s[0]]++
        for (i in 1 until len + 1) {
            s[i] = s[i - 1] + (nums[i - 1] and 1)
            count[s[i]]++
        }
        var ans = 0
        for (i in 1 until len + 1) {
            //s[i] - s[j] = k
            //s[j] = s[i] - k
            if (s[i] - k >= 0) {
                ans += count[s[i] - k]
            }
        }
        return ans
    }

    fun numberOfSubarrays2(nums: IntArray, k: Int): Int {
        var l = 0
        var r = 0
        var oldCnt = 0
        var res = 0
        while (r < nums.size){
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if (nums[r++] and 1 == 1) {
                oldCnt ++
            }
            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
            if (oldCnt == k){
                val temp = r
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                // rightEvenCnt 即为第 k 个奇数右边的偶数的个数
                while (r < nums.size && nums[r] and 1 == 0) {
                    r++
                }
                val rDiff = r - temp
                var lDiff = 0
                while (l < nums.size && nums[l] and 1 == 0){
                    l ++
                    lDiff ++
                }
                res += (lDiff + 1) * (rDiff + 1)
                l++
                oldCnt--
            }
        }
        return res
    }
}