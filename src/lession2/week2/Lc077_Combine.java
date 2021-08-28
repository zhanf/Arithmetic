package lession2.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc077_Combine {

    int k;
    int n;
    List<List<Integer>> ans = new ArrayList();
    List<Integer> set = new ArrayList();

    /**
     * 77. 组合
     * 参考 78 题
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        findSubsets(1);
        return ans;
    }

    public void findSubsets(int i) {
        //选的数已经超过 k 个，或者 剩下的数全选也不够 k 个
        if (set.size() > k || set.size() + n - i + 1 < k) {
            return;
        }
        if (i == n + 1) {
            ans.add(new ArrayList<Integer>(set));
            return;
        }
        findSubsets(i + 1);
        set.add(i);
        findSubsets(i + 1);
        set.remove(set.size() - 1);
    }
}
