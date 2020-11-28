package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.LinkedList;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/15
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Clarification: 两个二叉树是否相同
        // 方案1: dfs 聚合: 当前节点相同，且左右子树均相同
        // 递归参数: 第一个树当前节点，第二个树当前节点

        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        // terminator
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        // process current logic
        if (p.val != q.val) {
            return false;
        }

        // drill down
        boolean lEqual = dfs(p.left, q.left);
        boolean rEqual = dfs(p.right, q.right);

        // reverse current states

        return lEqual && rEqual;
    }

    public boolean isSameTreeTwo(TreeNode p, TreeNode q) {
        // 方案2: bfs 使用队列辅助

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }

            if (node1.left == null ^ node2.left == null) {
                return false;
            }
            if (node1.right == null ^ node2.right == null) {
                return false;
            }

            if (node1.left != null) {
                queue1.offer(node1.left);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
            }

            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (node2.right != null) {
                queue2.offer(node2.right);
            }
        }

        return true;
    }
}
