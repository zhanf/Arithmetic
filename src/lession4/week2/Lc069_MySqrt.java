package lession4.week2;

/**
 * 69. x 的平方根
 */
public class Lc069_MySqrt {

    public int mySqrt(int x) {
        long left = 0;
        //注意边界问题
        long right = ((long) x + 1) / 2;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            //mid * mid 注意边界问题，所以用 long
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
