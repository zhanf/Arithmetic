package lession2.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc046_Permute {
    //所有结果集合
    List<List<Integer>> ans = new ArrayList<>();
    //单个结果集合
    List<Integer> tmp = new ArrayList<>();
    //是否被访问
    boolean[] visited;
    //原数组
    int[] num;
    //原数组长度
    int n;

    /**
     * 46. 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        //模板，初始化
        n = nums.length;
        num = new int[nums.length];
        for (int i = 0; i < n; i++) num[i] = nums[i];
        visited = new boolean[n];
        dsf(0);
        return ans;
    }

    //层数
    private void dsf(int depth) {
        if (n == depth) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int index = 0; index < n; index++) {
            //已经访问过了，调到下一个
            if (visited[index]) continue;
            //已经访问过了
            visited[index] = true;
            //记录值
            tmp.add(num[index]);
            //递归
            dsf(depth + 1);

            //还原现场
            tmp.remove(tmp.size() - 1);
            visited[index] = false;
        }
    }
}
