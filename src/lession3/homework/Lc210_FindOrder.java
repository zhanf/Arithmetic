package lession3.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 参考 207
 */
public class Lc210_FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        addEdges(numCourses, prerequisites);
        if (numCourses == topSort(numCourses)) return result;
        return new int[0];
    }

    private int topSort(int numCourses) {
        int learn = 0;
        Queue<Integer> queue = new LinkedList<>();
        //拓扑排序，入度为 0 的数的 索引 放入队列
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                //放入索引
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            result[learn] = pre;
            learn++;
            for (Integer cur : edges.get(pre)) {
                if (--deg[cur] == 0) queue.offer(cur);
            }
        }
        return learn;
    }

    /**
     * 1、构建有向无环图
     * 2、记录入度
     *
     * @param numCourses
     * @param prerequisites
     */
    private void addEdges(int numCourses, int[][] prerequisites) {
        deg = new int[numCourses];
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] child : prerequisites) {
            deg[child[0]]++;
            edges.get(child[1]).add(child[0]);
        }
    }

    List<List<Integer>> edges;
    int[] deg;
    int[] result;
}
