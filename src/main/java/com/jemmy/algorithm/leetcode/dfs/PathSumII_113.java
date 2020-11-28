package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/26
 */
public class PathSumII_113 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Clarification: 二叉树的路径和等于指定值
        // 方案1: dfs + 回溯
        // 结点的值可能为负数，不能认为curSum > sum 就说明该条链路不符合要求，很可能子结点值为负数
        // 递归参数: 节点，路径，当前和，目标和

        List<Integer> path = new LinkedList<>();
        dfs(root, path, 0, sum);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> path, int curSum, int sum) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        curSum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (curSum == sum) {
                res.add(new ArrayList<>(path));
            }
            // 回溯叶子节点: curSum 是值变量，不需要回溯
            path.remove(path.size() - 1);
            return;
        }

        // drill down
        dfs(node.left, path, curSum, sum);
        dfs(node.right, path, curSum, sum);

        // 回溯中间节点: curSum 是值变量，不需要回溯
        path.remove(path.size() - 1);
    }

    // 方案2: 迭代 TOD
}
