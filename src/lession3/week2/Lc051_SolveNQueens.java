package lession3.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Lc051_SolveNQueens {

    //所有结果集合
    List<List<Integer>> ans = new ArrayList<>();
    //单个结果集合
    List<Integer> tmp = new ArrayList<>();
    //是否被访问
    boolean[] visited;

    HashMap<Integer, Boolean> userPlusJ = new HashMap<>();
    HashMap<Integer, Boolean> userMinusJ = new HashMap<>();
    //原数组长度
    int n;

    /**
     * 51. N 皇后
     *
     * @param n
     * @return 全排列（46题目）筛选出符合条件的排列
     * 筛选条件：水平、竖直、正斜线、反斜线 的方向没有重复点。
     * 即 row 不相等，column 不相等， row+column 不相等， row-column 不相等。
     */
    public List<List<String>> solveNQueens(int n) {
        //模板，初始化
        this.n = n;
        visited = new boolean[n];
        dsf(0);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> per : ans) {
            List<String> row_result = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(".");
                }
                int col = per.get(row);
                sb.replace(col, col + 1, "Q");
                row_result.add(sb.toString());
            }
            result.add(row_result);
        }
        return result;
    }

    //层数
    private void dsf(int row) {
        if (n == row) {
            for (Integer y : tmp) {
                System.out.print(y);
            }
            System.out.println("");
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!visited[col] && !userPlusJ.getOrDefault(row + col, false) &&
                    !userMinusJ.getOrDefault(row - col, false)) {
                //已经访问过了
                visited[col] = true;
                userPlusJ.put(row + col, true);
                userMinusJ.put(row - col, true);
                //记录值
                tmp.add(col);
                //递归
                dsf(row + 1);
                //还原现场
                tmp.remove(tmp.size() - 1);
                userMinusJ.put(row - col, false);
                userPlusJ.put(row + col, false);
                visited[col] = false;
            }
        }
    }
}
