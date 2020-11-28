package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 示例 1：
 *
 * 输入： 3 / \ 9  20 /  \ 15   7 输出：[3, 14.5, 11] 解释： 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/12
 */
public class AverageOfLevelsInBinaryTree_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        // Clarification: 二叉树层序遍历，然后获取每层的平均值
        // 方案1: bfs 使用队列辅助

        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 使用 int 类型，在求和的时候会溢出
            long sum = 0;

            // 记住该层结点个数，因为下面的循环要往队列放子结点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                // 将左右子结点放入队列中，后续处理
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            double average = sum / size;
            res.add(average);
        }

        return res;
    }

    public List<Double> averageOfLevelsTwo(TreeNode root) {
        // 方案2: dfs TODO

        return null;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        TreeNode left = new TreeNode(2147483647);
        TreeNode right = new TreeNode(2147483647);
        root.left = left;
        root.right = right;

        AverageOfLevelsInBinaryTree_637 instance = new AverageOfLevelsInBinaryTree_637();
        List<Double> res = instance.averageOfLevels(root);
        System.out.println(res);
    }

}
