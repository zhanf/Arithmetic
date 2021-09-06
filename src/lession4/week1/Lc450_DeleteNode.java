package lession4.week1;

import stuck.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class Lc450_DeleteNode {
    /**
     * 其实没太理解该解法
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return null;
        if (root.val == key) {
            //如果没有左子树，让右子树代替返回
            if (root.left == null) return root.right;
            //如果没有右子树，让左子树代替返回
            if (root.right == null) return root.left;
            //下面两行，左右子树都有，找到当前节点的后继节点
            TreeNode next = root.right;
            while (null != next.left) next = next.left;
            /**
             * 这一块没太理解！！！
             */
            //遍历删除右子树，key 为右子树的值，为当前节点的右子树
            root.right = deleteNode(root.right, next.val);
            //当前节点的值替换为右子树的值
            root.val = next.val;

            //替换上面两行也可以
//            next.left = root.left;
//            root = root.right;
        }
        //如果当前值小于目标值，找右子树
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //如果当前值大于目标值，找左子树
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
