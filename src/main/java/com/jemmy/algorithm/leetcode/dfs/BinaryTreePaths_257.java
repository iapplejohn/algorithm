package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/4
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        // Clarification: 二叉树的所有路径
        // 方案1：深度优先搜索
        // 递归参数: 节点, 当前路径, 所有路径列表
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n^2)

        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, "", res);

        return res;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        // terminator
        if (node == null) {
            res.add(path);
            return;
        }

        // process current logic
        if (path.isEmpty()) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        // drill down
        if (node.left != null) {
            dfs(node.left, path, res);
        }
        if (node.right != null) {
            dfs(node.right, path, res);
        }

        // reverse current states 因为 String 不可变，所以不用 reverse
    }

    private void dfs2(TreeNode node, String path, List<String> res) {
        StringBuilder builder = new StringBuilder();

        // process current logic
        builder.append(node.val);

        // terminator 叶子节点
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        // drill down
        builder.append("->");
        if (node.left != null) {
            dfs(node.left, builder.toString(), res);
        }
        if (node.right != null) {
            dfs(node.right, builder.toString(), res);
        }

        // reverse current states 因为 String 不可变，所以不用 reverse
    }

    public List<String> binaryTreePathsTwo(TreeNode root) {
        // 方案2: 广度优先搜素
        // 使用两个queue，分别暂存节点和路径

        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<String> pathQueue = new LinkedList<>();

        // 初始化: 放入 root 节点
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));

        while (!nodeQueue.isEmpty() && !pathQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            StringBuilder builder = new StringBuilder(path);
            builder.append(node.val);
            if (node.left == null && node.right == null) {
                res.add(builder.toString());
                continue;
            }

            builder.append("->");
            if (node.left != null) {
                nodeQueue.offer(node.left);
                pathQueue.offer(builder.toString());
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.offer(builder.toString());
            }
        }

        return res;
    }
}
