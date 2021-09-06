package lession4.week2;

/**
 * 410. 分割数组的最大值
 */
public class Lc410_SplitArray {

    /**
     * 二分答案
     * 判定问题，动态计算 left right 范围，再取 mid，left right 分别为每个分一组和只分一组情况
     * isValid 为判定如果 最大值为 T 的情况下，分的数组长度是否满足不大于 m
     * 最后求最小的符合范围的值，while 里的条件取左值，right 左移。
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;//下界，每个都分一组
        int right = 0;//上界，只分一组
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean isValid(int[] nums, int m, int T) {
        int groupCount = 1;//至少分一组
        int groupSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (groupSum + nums[i] <= T) {
                groupSum += nums[i];
            } else {
                //新开一组
                groupCount++;
                //新开了一组，此时已是新组的第一个值，所以覆盖 groupSum
                groupSum = nums[i];
            }
        }
        return groupCount <= m;
    }
}
