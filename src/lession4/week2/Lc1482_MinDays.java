package lession4.week2;

/**
 * 1482. 制作 m 束花所需的最少天数
 */
public class Lc1482_MinDays {
    /**
     * 二分答案，判定求解
     * isValid 判断在第几天是否能成功制作花束
     * 算出 left right 的边界天数，二分求出目标天数
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int MAX = 1000000001;
        int right = MAX;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else left = mid + 1;
        }
        if (right == MAX) return -1;
        return right;
    }

    //在第 day 天，是否可以成功制作花束
    private boolean isValid(int[] bloomDay, int m, int k, int day) {
        int bloomCount = 0;
        int consecutive = 0;//连续的花
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {//当 nums[i] 小于 day,说明这一天花已经开了
                consecutive++;
                //可以制作花了
                if (consecutive == k) {
                    bloomCount++;
                    consecutive = 0;
                }
            } else {
                //说明不连续了，consecutive 复位
                consecutive = 0;
            }
        }
        //制作的花数量大于 m
        return bloomCount >= m;
    }
}
