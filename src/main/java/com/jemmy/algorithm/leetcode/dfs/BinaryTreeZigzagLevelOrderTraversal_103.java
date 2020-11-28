package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/3
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Clarification: 从左到右，从右到左遍历
        // 方案1: bfs 使用队列辅助，放入队列方式(FIFO)不变，每一层创建一个列表，通过层数奇偶性，来觉得放入元素值的顺序

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                // 偶数层: 从左到右遍历
                if ((level & 1) == 0) {
                    list.add(node.val);
                } else { // 奇数层: 从右到左遍历
                    list.push(node.val);
                }
            }

            res.add(list);
            level++;
        }

        return res;
    }

    public List<List<Integer>> zigzagLevelOrderTwo(TreeNode root) {
        // 方案2: bfs TODO 使用队列辅助，通过变量，来决定放入队列的顺序
        // 方案3: dfs 实现 bfs

        return null;
    }

}
