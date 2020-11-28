package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/19
 */
public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        // Clarification: 所有左叶子之和，处理时，需要下探一层判断，当前节点无法知道是否父节点的左子节点
        // 方案1: 递归
        // 递归参数: 当前节点
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int res = dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return 0;
        }

        int sum = 0;
        // process current logic 左子节点是否叶子节点
        if (node.left != null && isLeafNode(node.left)) {
            sum += node.left.val;
        }

        // drill down
        sum += dfs(node.left);
        sum += dfs(node.right);

        // reverse current states

        return sum;
    }

    public int sumOfLeftLeavesPlus(TreeNode root) {
        // 方案1: 递归
        // 递归参数: 当前节点

        int res = dfs2(root);
        return res;
    }

    private int dfs2(TreeNode node) {
        // terminator
        if (node == null) {
            return 0;
        }

        int sum = 0;
        // process current logic
        // drill down
        if (node.left != null) {
            sum += isLeafNode(node.left) ? node.left.val : dfs2(node.left);
        }

        if (node.right != null && !isLeafNode(node.right)) {
            sum += dfs(node.right);
        }
        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
