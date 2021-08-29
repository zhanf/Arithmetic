package lession3.homework;

import stuck.TreeNode;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Lc106_BuildTree {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder) return null;
        for (int i = 0; i < inorder.length; i++) memo.put(inorder[i], i);
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int in_start, int in_end, int[] postorder, int pos_start, int pos_end) {
        if (in_start > in_end || pos_start > pos_end) return null;
        int root_val = postorder[pos_end];
        int in_order_index = memo.get(root_val);

        TreeNode root = new TreeNode(root_val);

        root.left = buildTree(in_start, in_order_index - 1, postorder, pos_start, pos_start + in_order_index - in_start - 1);
        root.right = buildTree(in_order_index + 1, in_end, postorder, pos_start + in_order_index - in_start, pos_end - 1);
        return root;
    }
}
