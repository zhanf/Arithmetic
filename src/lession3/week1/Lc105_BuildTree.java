package lession3.week1;

import stuck.TreeNode;

public class Lc105_BuildTree {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return 分治法，分成子问题来看。变量是两数组的 index
     * 前序数组的第一个位置是头结点，找到该节点对应在中序数组的位置，中序数组该位置之前的为头节点的左节点，位置之后为头节点的右节点。
     * 构建 node 节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder) return null;
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        root.left = buildTree(preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, i_root_index);
        root.right = buildTree(preorder, p_start + 1 + leftNum, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }
}
