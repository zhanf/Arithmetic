package lession1.week2;

import java.util.HashMap;

public class Lc042_Trap {

    /**
     * 42. 接雨水
     */
    public int trap(int[] height) {
        int len = height.length;
        //两个数组，分别记录前值最大值和后值最大值
        int[] pre = new int[len + 2];
        int[] suf = new int[len + 2];
        //  [0,2,1,5,2]
        //[0,0,2,2,5,5,0]
        //[0,5,5,5,5,2,0]
        for (int i = 1; i <= len; i++) {
            pre[i] = Math.max(pre[i - 1], height[i - 1]);
        }
        for (int i = len; i >= 1; i--) {
            suf[i] = Math.max(suf[i + 1], height[i - 1]);
        }
        int ans = 0;
        //前值跟后值最最小值，与当前值求diff
        for (int i = len; i >= 1; i--) {
            ans += Math.max(0, Math.min(pre[i - 1], suf[i + 1]) - height[i - 1]);
        }
        return ans;
    }

}