package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/30
 */
public class BinaryTreeLevelOrderTraversalII_107 {

    private LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Clarification: 二叉树的层次遍历，从底部开始
        // 方案1：bfs，使用队列辅助，反向存储到链表中，输出正向
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.addFirst(list);
        }

        return res;
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderBottomTwo(TreeNode root) {
        // 方案2: dfs，根据层数，获取对应的列表，新建或往里面添加元素
        // 递归参数: 当前节点, 层数
        dfs(root, 0);

        // 反向输出：从底部开始
        Collections.reverse(ans);

        return ans;
    }

    private void dfs(TreeNode node, int level) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        List<Integer> list;
        if (ans.size() <= level) {
            list = new ArrayList<>();
            ans.add(list);
        } else {
            list = ans.get(level);
        }
        list.add(node.val);

        // drill down
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }

        // reverse current states
    }
}
