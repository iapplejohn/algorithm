package com.jemmy.algorithm.leetcode.tree;

import com.jemmy.algorithm.everyday.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/30
 */
public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // Clarification: 判断是否有根结点到叶子节点的路径之和为目标值
        // 方案1：dfs

        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode node, int curSum, int sum) {
        // terminator
        if (node == null) {
            return false;
        }

        // process current logic
        curSum += node.val;
        if (node.left == null && node.right == null) {
            return curSum == sum;
        } else {
            // drill down 聚合：左子树或右子树其中之一满足条件即可
            return dfs(node.left, curSum, sum) || dfs(node.right, curSum, sum);
        }
        // reverse current states
    }

    public boolean hasPathSumTwo(TreeNode root, int sum) {
        // 方案2：BFS 使用队列辅助

        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer curSum = sumQueue.poll();

            if (node.left == null && node.right == null) {
                if (curSum == sum) {
                    return true;
                }
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(curSum + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(curSum + node.right.val);
                }
            }
        }

        return false;
    }
}
