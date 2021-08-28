package lession2.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc022_GenerateParenthesis {

    public static void main(String[] args) {
        new Lc022_GenerateParenthesis().generateParenthesis(1);
    }

    /**
     * 22. 括号生成
     * 分治，分成 (a)b问题
     * (a) 为 k 个括号，a 则 k-1 个括号
     * b 为 n-k 个括号，
     * 当 n 为 0 时候，返回长度为 1 的空字符串数组
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>() {{
            add("");
        }};
        List<String> ans = new ArrayList();

        for (int k = 1; k <= n; k++) {
            List<String> result_a = generateParenthesis(k - 1);
            List<String> result_b = generateParenthesis(n - k);
            for (String a : result_a) {
                for (String b : result_b) {
                    ans.add("(" + a + ")" + b);
                }
            }
        }
        return ans;
    }
}
