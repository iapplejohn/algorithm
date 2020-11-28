package com.jemmy.algorithm.leetcode.tree;

import com.jemmy.algorithm.everyday.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/29
 */
public class SumRootToLeafNumbers_129 {

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        // Clarification: 从根到叶子节点路径上的节点值拼接成数字，求数字之和
        // 方案1：字符串 递归+回溯

        StringBuilder builder = new StringBuilder();
        recursive(root, builder);
        return res;
    }

    private void recursive(TreeNode node, StringBuilder builder) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        if (isLeaf(node)) {
            builder.append(node.val);
            res += Integer.valueOf(builder.toString());
            return;
        }

        // drill down
        if (node.left != null) {
            recursive(node.left, builder);
        }
        if (node.right != null) {
            recursive(node.right, builder);
        }

        // reverse current states
        builder.deleteCharAt(builder.length() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int sumNumbersTwo(TreeNode root) {
        // 方案2：数字 递归
        // 递归参数：当前节点，上面节点累下来的数字和
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int prevSum) {
        // terminator
        if (node == null) {
            return 0;
        }

        // process current logic
        int sum = prevSum * 10 + node.val;
        if (isLeaf(node)) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

    public int sumNumbersThree(TreeNode root) {
        // 方案3：BFS 使用两个队列分别存储节点和数字之和

        if (root == null) {
            return 0;
        }

        int sum = 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer prevSum = sumQueue.poll();
            if (node.left == null && node.right == null) {
                sum += prevSum;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(prevSum * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(prevSum * 10 + node.right.val);
                }
            }
        }

        return sum;
    }
}
