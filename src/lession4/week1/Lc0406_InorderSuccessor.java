package lession4.week1;

import stuck.TreeNode;

/**
 * 0406 插入
 */
public class Lc0406_InorderSuccessor {

    //目标值有右子树，遍历找右子树的左子树，没有右子树，则找遍历过的最小值
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSucc(root, p.val);
    }

    private TreeNode inorderSucc(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode ans = null;
        while (null != curr) {
            if (curr.val > val) {//case2: 当后继存在于一个经过的点中，记录最小值
                if (null == ans || ans.val > curr.val) {
                    ans = curr;
                }
            }

            if (curr.val == val) {//case1: 检索到 val 且右子树存在，找右子树的左子树
                if (null != curr.right) {
                    curr = curr.right;
                    while (null != curr.left) {
                        curr = curr.left;
                    }
                    ans = curr;
                }
                break;
            }
            if (curr.val < val) {
                curr = curr.right;
            } else curr = curr.left;
        }
        return ans;
    }

    //比解法一更好理解
    private TreeNode inorderSucc2(TreeNode root, int val) {
        TreeNode pre = null;
        while (root.val != val) {
            if (root.val > val) {
                pre = root;
                root = root.left;
            } else {
                root = root.right;
            }
            if (null == root.right) {
                return pre;
            }
            root = root.right;
            while (null != root.left) root = root.left;
        }
        return root;
    }
}
