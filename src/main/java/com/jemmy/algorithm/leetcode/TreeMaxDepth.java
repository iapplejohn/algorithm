package com.jemmy.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 * @author zhujiang.cheng
 * @since 2020/6/17
 */
public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        // 方案1: 递归
        // 时间复杂度: O(n)
        // 空间复杂度:
        if (root == null) {
            return 0;
        }

        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        return Math.max(d1, d2) + 1;
    }

    public int maxDepth_2(TreeNode root) {
        // 方案2: 迭代，使用栈
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)
        // 1. 将root和深度放到栈中
        // 2. 从栈中拿树和深度，和最大深度比较，分成左子树和右子树，将两个子树和深度放到栈中
        // 3. 重复2
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }

        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();

            if (current != null) {
                TreeNode node = current.k;
                int depth = current.v;

                maxDepth = Math.max(maxDepth, depth);
                if (node.left != null) {
                    stack.add(new Pair<>(node.left, depth + 1));
                }
                if (node.right != null) {
                    stack.add(new Pair<>(node.right, depth + 1));
                }
            }
        }

        return maxDepth;
    }
}

class Pair<K, V> {
    public K k;
    public V v;

    public Pair(K k , V v) {
        this.k = k;
        this.v = v;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
