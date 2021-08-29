package lession3.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc684_FindRedundantConnection {
    private int n;

    /**
     * 684. 冗余连接
     *
     * @param input
     * @return dfs,1、模板代码：构建出边数组，构建访问记录数组 visit
     * 2、模板代码：加边
     * 3、构建无向 双边图
     * 4、每次构建时候还原 visit 数组，并判断是否有环
     */
    public int[] findRedundantConnection(int[][] input) {
        for (int[] edge : input) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        ///初始化模板
        // 初态：[[], [], ... []]
        edges = new ArrayList<>();
        // [false, false, ...]
        visit = new boolean[n + 1];
        ///初始化访问数组
        for (int i = 0; i <= n; i++) {
            visit[i] = false;
            edges.add(new ArrayList<>());
        }
        hasCycle = false;

        // 加边
        for (int[] edge : input) {
            int x = edge[0];
            int y = edge[1];
            // 无向图看作双向边的有向图
            addEdge(x, y);
            addEdge(y, x);

            // 每加一条边，还原 visit 共享数组
            for (int i = 0; i <= n; i++) visit[i] = false;
            // 每加一条边，看图中是否多了环c
            dsf(x, -1);
            if (hasCycle) return edge;
        }
        return null;
    }

    // 模板：无向图深度优先遍历找环
    // visit数组，避免重复访问
    // fa是第一次走到x的点
    private void dsf(int x, int fa) {
        visit[x] = true;
        for (Integer y : edges.get(x)) {
            if (y == fa) continue;
            if (visit[y]) hasCycle = true;
            else dsf(y, x);
        }
    }

    // 模板：加边
    private void addEdge(int x, int y) {
        edges.get(x).add(y);
    }

    // 出边数组
    private List<List<Integer>> edges;
    private boolean[] visit;
    private boolean hasCycle;
}
