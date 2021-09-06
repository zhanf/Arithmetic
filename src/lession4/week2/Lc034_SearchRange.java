package lession4.week2;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Lc034_SearchRange {

    /**
     * 二分,模板方法
     * 找到第一个 >= target 的值，找到最后一个 <= target 的值
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = nums.length;
        //第一个 >= target 的值
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        ans[0] = right;

        left = -1;
        right = nums.length - 1;
        //最后一个 <= target 的值
        while (left < right) {
            int mid = (left + right + 1) >> 1;//3. 通用模板 (left + right) << 1 ,但如果 2 是给 left 赋值，则 + 1 处理
            if (nums[mid] <= target) //1，以 nums[mid] 写条件
                left = mid;//2. 处理边界
            else right = mid - 1;
        }
        ans[1] = right;
        if (ans[0] > ans[1]) {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}
