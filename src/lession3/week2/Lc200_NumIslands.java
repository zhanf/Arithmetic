package lession3.week2;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class Lc200_NumIslands {

    /**
     * dfs,
     */
    public int numIslands(char[][] grid) {
        //visited 记录访问路径
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                visited[x][y] = false;
            }
        }

        int ans = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                //为 1 且没有走过开始 dfs
                if (grid[x][y] == '1' && !visited[x][y]) {
                    dfs(x, y);
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * dfs 模板，第一步标记已访问
     * 第二步遍历所有出边
     */
    private void dfs(int x, int y) {
        // 第一步：标记已访问
        visited[x][y] = true;
        //四个方向，第二步：遍历所有出边
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //任何数组访问前，判断合法性
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    /**
     * bfs 借助队列
     */
    private void bfs(int sx, int sy) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sx, sy));
        // 标记已访问
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            //四个方向，第二步：遍历所有出边
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //任何数组访问前，判断合法性
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                    queue.add(new Pair<>(nx, ny));
                    //标记已访问
                    visited[nx][ny] = true;
                }
            }
        }
    }


    int m;
    int n;
    boolean[][] visited;
    char[][] grid;
    int[] dx = {1, 0, -1, 0};//右下左上
    int[] dy = {0, 1, 0, -1};


}
