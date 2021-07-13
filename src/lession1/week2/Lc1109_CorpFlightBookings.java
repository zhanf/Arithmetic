package lession1.week2;

import java.util.Arrays;

public class Lc1109_CorpFlightBookings {

    /**
     * 1109. 航班预订统计
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n + 2];
        //把 A 的第 l 个数到第 r 个数加 d,A 的差分数组 B 的变化为 B(l)+d,B(r+1)-d
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            int fir = booking[0];
            int last = booking[1] + 1;
            int seats = booking[2];
            ans[fir] += seats;
            ans[last] -= seats;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
        int[] res = new int[n + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + ans[i];
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }
}
