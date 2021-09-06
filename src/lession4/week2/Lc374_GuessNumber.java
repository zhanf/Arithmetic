package lession4.week2;

/**
 * 374. 猜数字大小
 */
public class Lc374_GuessNumber {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
//            long mid = ((long)left + right) >> 1;//会溢出，leetCode 提示超时，其实是溢出了！！！溢出问题耗费了大量时间！！！
            //位运算符一定要加括号，优先级不跟 * 一样高，left + (right - left) >> 1 会被处理成 (left + right - left\) >>1
            int mid = left + ((right - left) >> 1);
            if (guess(mid) <= 0) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private int guess(int target) {
        //TODO  mock
        return -1;
    }
}
