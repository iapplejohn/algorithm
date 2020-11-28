package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *  
 *
 * 例如, 
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *  
 *
 * 提示：
 *
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/30
 */
public class InsertINtoABinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Clarification: 往二叉搜索树插入节点
        // 方案1: 循环，找到待插入位置，然后新增节点，并将父节点的左/右指针指向该节点
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }

        TreeNode prev = root, parent = root;
        boolean left = false;
        while (prev != null) {
            parent = prev;
            if (prev.val > val) {
                prev = prev.left;
                left = true;
            } else {
                prev = prev.right;
                left = false;
            }
        }

        if (left) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return root;
    }
}
