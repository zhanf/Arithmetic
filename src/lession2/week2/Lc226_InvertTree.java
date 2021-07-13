package lession2.week2;

import stuck.TreeNode;

public class Lc226_InvertTree {
    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return null;
        //保存左节点
        TreeNode left = invertTree(root.left);
        //左节点设置为右节点
        root.left = invertTree(root.right);
        //右节点设为左节点
        root.right = left;
        return root;
    }
}
