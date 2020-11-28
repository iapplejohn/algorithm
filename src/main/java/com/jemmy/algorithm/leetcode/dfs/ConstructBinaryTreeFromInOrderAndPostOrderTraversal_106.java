package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/25
 */
public class ConstructBinaryTreeFromInOrderAndPostOrderTraversal_106 {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Clarification: 根据中序和后序遍历，构造二叉树，没有重复元素
        // 方案1：递归 后序最后一位是根，拿这个根去中序定位，拿到左子树和右子树
        // 递归参数：中序数组，后续数组，中序左边界、右边界，后续左边界、右边界

        // 映射: 值-中序位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recursive(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode recursive(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        // terminator
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        // process current logic
        // 构建根节点
        int rootVal = postorder[postRight];
        TreeNode node = new TreeNode(rootVal);
        // 获取根节点在中序遍历的位置，据此来确定左右子树
        int rootIdx = map.get(rootVal);


        // drill down
        // 左子树
        node.left = recursive(inorder, postorder, inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - inLeft - 1);
        // 右子树
        node.right = recursive(inorder, postorder, rootIdx + 1, inRight, postLeft + rootIdx - inLeft, postRight - 1);

        // reverse current states
        return node;
    }
}
