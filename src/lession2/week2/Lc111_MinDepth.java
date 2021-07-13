package lession2.week2;

import stuck.TreeNode;

public class Lc111_MinDepth {

    /**
     * 111. 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left && null == root.right) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (null != root.left) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (null != root.right) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }

}
