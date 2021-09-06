package lession4.week1;

import stuck.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class Lc701_InsertIntoBST {

    /**
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //2. 处理边界问题，如题描述都不重复，如果没有找到则插入，即返回新节点
        if (null == root) {
            return new TreeNode(val);
        }
        // 1.比较大小，如果 val 比当前 root 的值小，则找 root.left,反之找右节点
        if (val < root.val) {
            // 3. 新节点作为当前节点的左节点
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
