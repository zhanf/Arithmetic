package lession4.week2;

/**
 * 704. 二分查找
 */
public class Lc704_Search {

    /**
     * 二分，模板方法
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;
        int left = -1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;//3. 通用模板 (left + right) << 1 ,但如果 2 是给 left 赋值，则 + 1 处理
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) //1，以 nums[mid] 写条件
                left = mid;//2. 处理边界
            else right = mid - 1;
        }
        return -1;
    }
}
