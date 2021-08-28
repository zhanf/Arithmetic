package lession2.homework;

import java.util.HashMap;
import java.util.Map;

public class Lc697_FindShortestSubArray {

    /**
     * 697. 数组的度
     * 1,map 保存 nums[i]，int[]；int[]记录三个值，一是出现次数，二是开始index，三是结束index
     * 2,遍历map，取出现次数最多的次数，同时记录结束index与开始index的差值
     * 3，如果次数相同，取结束index与开始index的差值的较小值
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap();
        int length = nums.length;
        //1
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxCount = 0;
        int minLine = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (maxCount < value[0]) {
                //2
                maxCount = value[0];
                minLine = value[2] - value[1] + 1;
            } else if (maxCount == value[0]) {
                //3
                if (minLine > value[2] - value[1] + 1) {
                    minLine = value[2] - value[1] + 1;
                }
            }
        }
        return minLine;
    }
}
