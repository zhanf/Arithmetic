package lession4.week2;

import stuck.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class Lc538_ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //关键点在 sum 存值，我当时没考虑用变量存，所以在当时在处理边界条件  if (null == root) 时，不知道怎么返回
        if (null != root) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
