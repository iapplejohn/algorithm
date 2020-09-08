package com.jemmy.algorithm.leetcode.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/4
 */
public class BinaryTreeLevelOrderTraversal_102 {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Clarification: 逐层地，从左到右访问所有节点
        // 方案1: 深度优先
        // 递归的时候，需要知道当前是哪一层，然后将访问到的值，追加到该层列表中
        // 递归参数: 节点，当前层数

        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode node, int level) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        List<Integer> levelList = list.get(level);
        levelList.add(node.val);

        // drill down
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

        // reverse current states
    }

    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        // 方案2: 广度优先 使用队列辅助
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> levelList = new ArrayList<>();
            res.add(levelList);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return res;
    }

}
