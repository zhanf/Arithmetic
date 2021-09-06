package lession4.week2;

/**
 * 162. 寻找峰值
 */
public class Lc162_FindPeakElement {

    /**
     * 三分查找法
     * 分两种情况，if (nums[lmid] <= nums[rmid]) left = lmid + 1; left 的左边可以舍弃
     * else rigth 的右边可以舍弃
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //虽然第二步是 left 赋值，但因为下面已经 +1 所以此处不能 +1
            int lmid = (left + right) >> 1;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid])
                // 必须 + 1，不清楚，可以算一下
                left = lmid + 1;
            else
                // 必须 -1，不清楚，可以算一下
                right = rmid - 1;
        }
        return left;
    }
}
