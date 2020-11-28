package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/14
 */
public class BinaryTreeInOrderTraversal_94 {

    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        // Clarification: 二叉树的中序遍历
        // 方案1: dfs
        // 递归参数: 当前节点

        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        recursive(root);
        return res;
    }

    private void recursive(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // drill down
        recursive(node.left);

        // process current logic
        res.add(node.val);

        // drill down
        recursive(node.right);

        // reverse current states
    }

    public List<Integer> inorderTraversalTwo(TreeNode root) {
        // 方案2: 迭代 使用队列辅助

        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 左节点递归入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 拿到最左节点
            curr = stack.pop();
            res.add(curr.val);

            // 右节点也可能有左子节点，需要递归入栈
            curr = curr.right;
        }

        return res;
    }
}
