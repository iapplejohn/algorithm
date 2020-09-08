package com.jemmy.algorithm.leetcode.top;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *    进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/2
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        // Clarification: 判断二叉树是否镜像对称
        // 方案1: 递归

        if (root == null) {
            return true;
        }

        return recursion(root, root);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        // terminator
        if (left == null && right == null) {
            return true;
        }

        // process current logic
        if (left != null && right != null && left.val == right.val) {
            // drill down
            boolean symmetric1 = recursion(left.left, right.right);
            boolean symmetric2 = recursion(left.right, right.left);
            return symmetric1 && symmetric2;
        } else {
            return false;
        }
        // reverse current states
    }

    public boolean isSymmetricTwo(TreeNode root) {
        // 方案2: 迭代，使用两个队列辅助

        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> leftQueue = new LinkedList<>();
        LinkedList<TreeNode> rightQueue = new LinkedList<>();

        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left != null && right != null && left.val == right.val) {
                leftQueue.offer(left.left);
                rightQueue.offer(right.right);

                leftQueue.offer(left.right);
                rightQueue.offer(right.left);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isSymmetricTwoPlus(TreeNode root) {
        // 方案2': 迭代，使用一个队列辅助

        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
