package lession2.week2;

import stuck.TreeNode;

public class Lc098_IsValidBST {

    long pre = Long.MIN_VALUE;

    /**
     * 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {

        //中序遍历
        if (null == root) return true;
        if (!isValidBST(root.left)) return false;
        //当前值与前值比较
        if (root.val <= pre) {
            return false;
        }
        //记录前值
        pre = root.val;
        return isValidBST(root.right);
    }

    /**
     * validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
     */
    public boolean validBST(TreeNode root, long lower, long upper) {
        if (null == root) return true;
        if (root.val <= lower) return false;
        if (root.val >= upper) return false;
        return validBST(root.left, lower, root.val) && validBST(root.right, root.val, upper);
    }
}
