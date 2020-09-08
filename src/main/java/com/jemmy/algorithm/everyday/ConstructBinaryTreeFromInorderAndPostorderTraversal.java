package com.jemmy.algorithm.everyday;

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
 * @since 2020/7/10
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Clarification: 给出中序和后序遍历的数组，返回二叉树，树没有重复的元素
        // 递归
        // 后序遍历的最后一个节点是根节点，在中序遍历中定位该元素，前面部分为左子树，后面部分为右子树，
        // 构建该节点，递归处理左子树和右子树，将返回值分别赋给该节点的left与right属性

        int inLen = inorder.length, postLen = postorder.length;
        if (inLen != postLen) {
            throw new IllegalArgumentException("The lengths are different");
        }

        // 空间换时间，通过哈希表存储中序遍历 节点值 - 位置映射
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return recursiveBuildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    public TreeNode recursiveBuildTree(
        int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {

        // terminator
        if (inLeft > inRight) {
            return null;
        }

        // process current
        // 后续遍历，最右边的节点是当前根结点
        int rootVal = postorder[postRight];

        // 在中序遍历中定位该元素
        int inRootIndex = map.get(rootVal);

        // 构建根节点
        TreeNode root = new TreeNode(rootVal);

        // drill down
        // 构建左子树，并赋给当前根结点的left属性
        root.left = recursiveBuildTree(
            inorder, inLeft, inRootIndex - 1, postorder, postLeft, postLeft + inRootIndex - inLeft - 1);

        // 构建右子树，并赋给当前根结点的right属性
        root.right = recursiveBuildTree(
            inorder, inRootIndex + 1, inRight, postorder, postLeft + inRootIndex - inLeft, postRight - 1);

        // reverse current

        return root;
    }

    public TreeNode buildTreeTwo(int[] inorder, int[] postorder) {
        // 迭代 TODO

        return null;
    }
}
