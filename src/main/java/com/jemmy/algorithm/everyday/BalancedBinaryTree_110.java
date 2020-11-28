package com.jemmy.algorithm.everyday;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/17
 */
public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        // Clarification: 判断给定的二叉树是否高度平衡的二叉树
        // 方案1: 递归，自顶向下
        // 递归参数: 当前节点，返回当前深度

        if (root == null) {
            return true;
        }

        // 当前节点左右节点的深度差不超过1，且左、右子树也是平衡树
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        // terminator
        if (node == null) {
            return 0;
        }

        // process current logic
        // drill down
        int lDepth = depth(node.left);
        int rDepth = depth(node.right);

        // reverse current states

        return Math.max(lDepth, rDepth) + 1;
    }

    public boolean isBalancedTwo(TreeNode root) {
        // 方案2: 自底向上，前序遍历

        return depth2(root) != -1;
    }

    private int depth2(TreeNode node) {
        // terminator
        if (node == null) {
            return 0;
        }

        // process current logic
        // drill down
        int lDepth = depth2(node.left);
        // 剪枝
        if (lDepth == -1) {
            return -1;
        }

        int rDepth = depth2(node.right);
        if (rDepth == -1) {
            return -1;
        }

        return Math.abs(lDepth - rDepth) < 2 ? Math.max(lDepth, rDepth) + 1 : -1;
    }

}
