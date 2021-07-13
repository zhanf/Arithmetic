package lession2.week2;

import stuck.TreeNode;

public class Lc104_MaxDepth {

    int deep = 0;

    /**
     * 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return deep;
        maxDepth(root, 1);
        return deep;
    }

    public void maxDepth(TreeNode root, int depth) {
        if (root == null) return;
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
        deep = Math.max(depth, deep);
    }

    public int maxDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int left = maxDepth2(root);
            int right = maxDepth2(root);
            return Math.max(left, right) + 1;
        }
    }
}
