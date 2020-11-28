package com.jemmy.algorithm.leetcode.tree;

import com.jemmy.algorithm.everyday.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/24
 */
public class CountCompleteTreeNodes_222 {

    private int count = 0;

    public int countNodes(TreeNode root) {
        // Clarification: 完全二叉树的节点个数，最底层节点可能没填满，且节点集中在最左边
        // 方案1：dfs，遍历所有节点，每次个数加1

        dfs(root);

        return count;
    }

    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        count++;

        // drill down
        if (node.left != null) {
            dfs(node.left);
        }

        if (node.right != null) {
            dfs(node.right);
        }

        // reverse current states
    }

    public int countNodesTwo(TreeNode root) {
        // 方案2：充分利用完全二叉树的特点，统计左右子树的层高，
        // 如果相等，说明左子树肯定填满了，个数为 2 ^ left - 1，加上 root 节点，然后再去递归处理右子树
        // 如果不相等，说明最后一层不满，但是倒数第二层满了，可以直接得到右子树的节点个数，加上 root 节点，再对左子树递归查找

        if (root == null) {
            return 0;
        }

        int levelLeft = countLevel(root.left);
        int levelRight = countLevel(root.right);
        if (levelLeft == levelRight) {
            return countNodesTwo(root.right) + (1 << levelLeft);
        } else {
            return countNodesTwo(root.left) + (1 << levelRight);
        }
    }

    private int countLevel(TreeNode node) {
        int level = 0;

        // 遍历，直接自顶向下
        while (node != null) {
            level++;
            node = node.left;
        }

        return level;
    }
}
