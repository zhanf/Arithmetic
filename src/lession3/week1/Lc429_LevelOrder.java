package lession3.week1;

import stuck.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc429_LevelOrder {


    /**
     * 429. N 叉树的层序遍历
     *
     * @param root
     * @return 层序遍历模板，用 Queue
     * 记录每层的数量 size 为 queue 的长度，遍历 size 次 pop ，清空当前层，并添加每层的 children 到 queue 中
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder2(Node root) {
        if (null != root) recur(root, 0);
        return ans;
    }

    public void recur(Node root, int level) {
        if (ans.size() <= level) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        if (null != root.children) {
            for (Node child : root.children) {
                recur(child, level + 1);
            }
        }
    }

}
