package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.LinkedList;

/**
 * 617. 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/23
 */
public class MergeTwoBinaryTrees_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Clarification: 合并二叉树，重叠值相加，否则作为新节点
        // 方案1：递归
        // 递归参数：t1, t2，往 t1 上加，返回 t1
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }

        t1.val += t2.val;

        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        // terminator
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }

        // process current logic
        t1.val += t2.val;

        // drill down
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        // reverse current states
        return t1;
    }

    public TreeNode mergeTreesTwo(TreeNode t1, TreeNode t2) {
        // 方案2：迭代 使用队列辅助
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            n1.val += n2.val;

            // 如果n1和n2的左子树都不为空，放到队列中，后续处理
            // 如果n1的左子树为空，将n2的左子树挂到n1的左子树上
            if (n1.left != null && n2.left != null) {
                queue.offer(n1.left);
                queue.offer(n2.left);
            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            // 右子树同样的处理
            if (n1.right != null && n2.right != null) {
                queue.offer(n1.right);
                queue.offer(n2.right);
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
        }

        return t1;
    }
}
