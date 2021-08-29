package lession3.week1;

import stuck.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc589_Preorder {
    private List<Integer> ans = new ArrayList();

    /**
     * 589. N 叉树的前序遍历
     *
     * @param root
     * @return stack 保存 root ,打印va，children 翻转后添加到 stack
     * while 循环条件是 stack 不为空
     */
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack();
        if (null == root) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            if (null != children) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    Node child = children.get(i);
                    stack.push(child);
                }
            }
        }
        return ans;
    }

    public List<Integer> preorde2(Node root) {
        if (null == root) return ans;
        ans.add(root.val);
        if (null != root.children) {
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return ans;
    }
}
