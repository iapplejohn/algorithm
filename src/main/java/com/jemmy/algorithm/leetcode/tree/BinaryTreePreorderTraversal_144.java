package com.jemmy.algorithm.leetcode.tree;

import com.jemmy.algorithm.everyday.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/27
 */
public class BinaryTreePreorderTraversal_144 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // Clarification: 二叉树的前序遍历 根 左 右
        // 方案1: dfs

        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        res.add(node.val);

        // drill down
        if (node.left != null) {
            dfs(node.left);
        }

        if (node.right != null) {
            dfs(node.right);
        }
    }

    public List<Integer> preorderTraversalTwo(TreeNode root) {
        // 方案2: 迭代 使用队列辅助

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                res.add(node.val);

                if (node.right != null) {
                    stack.offer(node.right);
                }
                if (node.left != null) {
                    stack.offer(node.left);
                }
            }
        }

        return res;
    }

    public List<Integer> preorderTraversalTwoPlus(TreeNode root) {
        // 方案2': 迭代 使用栈辅助

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                // 记录节点的值，左节点入栈，继续往左遍历
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
                // 节点出栈，获取其右节点，然后再走上面的逻辑
                TreeNode node = stack.pop();
                temp = node.right;
            }
        }

        return res;
    }
}
