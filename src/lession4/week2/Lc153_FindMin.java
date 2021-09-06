package lession4.week2;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class Lc153_FindMin {

    public int findMin(int[] nums) {
        int left = 0;//因为不必要返回 -1,所以从 0 开始取值
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            //升序，说明取左边数组
            if (nums[mid] <= nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[right];
    }
}
