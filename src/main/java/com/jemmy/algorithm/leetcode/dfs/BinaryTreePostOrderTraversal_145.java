package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/29
 */
public class BinaryTreePostOrderTraversal_145 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        // Clarification: 二叉树后序遍历
        // 方案1: dfs
        // 递归参数: 当前节点

        recursive(root);
        return res;
    }

    private void recursive(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // drill down
        recursive(node.left);
        recursive(node.right);

        // process current logic
        res.add(node.val);

        // reverse current states
    }

    // 方案2: 迭代
}
