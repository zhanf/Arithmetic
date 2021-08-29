package lession3.week1;

import stuck.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class Lc236_LowestCommonAncestor {

    private HashMap<Integer, TreeNode> father = new HashMap<>();

    /**
     * 236. 二叉树的最近公共祖先
     * 1、map 记录 node 的父节点关系。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) return null;
        calcFather(root);
        // p往上走到根，标红色
        HashSet<TreeNode> redNodes = new HashSet<>();
        redNodes.add(root);
        while (p.val != root.val) {
            redNodes.add(p);
            p = father.get(p.val);
        }
        // q往上走到第一个碰到红点时
        while (!redNodes.contains(q)) {
            q = father.get(q.val);
        }
        return q;
    }

    //DSF 记录值的父节点
    private void calcFather(TreeNode root) {
        if (null == root) return;
        if (null != root.left) {
            father.put(root.left.val, root);
            calcFather(root.left);
        }
        if (null != root.right) {
            father.put(root.right.val, root);
            calcFather(root.right);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (null == left) return right;
        if (null == right) return left;
        return root;
    }

}
