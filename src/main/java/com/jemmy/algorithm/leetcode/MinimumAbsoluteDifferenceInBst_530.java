package com.jemmy.algorithm.leetcode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/12
 */
public class MinimumAbsoluteDifferenceInBst_530 {

    private int res;
    private int pre;

    public int getMinimumDifference(TreeNode root) {
        // Clarification: 二叉搜索树（左子树小于根节点，右子树大于根节点），求最小差值
        // 方案1: 中序遍历 后的数据为升序数组，求相邻两个值的差，使用一个变量，记录前一个值
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        // drill down
        dfs(node.left);

        if (pre != -1) {
            res = Math.min(res, node.val - pre);
        }
        pre = node.val;

        dfs(node.right);

        // reverse current states
    }

}
