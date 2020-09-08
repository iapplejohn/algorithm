package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author zhujiang.cheng
 * @since 2020/7/30
 */
public class NAryTreePreorderTraversal_589 {

    public List<Integer> preorder(Node root) {
        // Clarification: N叉树 前序遍历
        // 方案1：递归
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    private void recursive(Node node, List<Integer> res) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        res.add(node.val);

        // drill down
        if (node.children != null) {
            for (Node child : node.children) {
                recursive(child, res);
            }
        }

        // restore current status
    }


    public List<Integer> preorderTwo(Node root) {
        // 方案2：迭代 + 栈辅助

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 使用双向链表来模拟栈
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null) {
                // 需要将子节点从右至左 push 到栈中，pop出来就是从左至右的
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }

        return res;
    }
}
