package com.jemmy.algorithm.leetcode.top;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/13
 */
public class KthSmallestElementInABst_230 {

    private int i = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        // Clarification: 二叉搜索树，第k小的元素
        // 方案1: 中序遍历 形成的数组是递增的，当遍历到第k个节点时，值即为所求

        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        // terminator
        if (node == null) {
            return;
        }

        // drill down
        dfs(node.left, k);

        // process current logic
        if (++i == k) {
            res = node.val;
            return;
        }

        dfs(node.right, k);

        // reverse current states
    }

    // 方案2: 迭代
}
