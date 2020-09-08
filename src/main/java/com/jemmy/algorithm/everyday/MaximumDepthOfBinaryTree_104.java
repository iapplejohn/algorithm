package com.jemmy.algorithm.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhujiang.cheng
 * @since 2020/7/28
 */
public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        // Clarification: 二叉树的最大深度
        // 方案1：递归

        // terminator
        if (root == null) {
            return 0;
        }

        // process current logic
        // drill down
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // restore current cache
    }

    public int maxDepthTwo(TreeNode root) {
        // 方案2: 迭代，使用队列
        // 将节点和深度放到队列中，每次从队列中拿，获取最大深度，然后再将子节点放到队列中

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.k;
            Integer depth = pair.v;

            maxDepth = Math.max(maxDepth, depth);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, depth + 1));
            }
        }

        return maxDepth;
    }

}
