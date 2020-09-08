package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.everyday.TreeNode;
import java.util.Random;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/3
 */
public class ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        // Clarification: 有序数组，转成平衡二叉树
        // 方案1: 二分法 + 递归，选择中间位置左边的数字作为根节点
        // 递归参数: 数组，左，右
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (nums == null || nums.length == 0) {
            return null;
        }

        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int left, int right) {
        // terminator
        if (left > right) {
            return null;
        }

        // process current logic
        // 中间位置左边的节点作为根节点
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        // drill down，先递归，然后汇总到root
        root.left = recursive(nums, left, mid - 1);
        root.right = recursive(nums, mid + 1, right);

        // reverse current states
        return root;
    }

    public TreeNode sortedArrayToBSTPlus(int[] nums) {
        // Clarification: 有序数组，转成平衡二叉树
        // 方案1: 二分法 + 递归，选择中间位置左边的数字作为根节点
        // 递归参数: 数组，左，右
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (nums == null || nums.length == 0) {
            return null;
        }

        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive2(int[] nums, int left, int right) {
        // terminator
        if (left > right) {
            return null;
        }

        // process current logic
        // 中间位置右边的节点作为根节点
        int mid = (left + right + 1) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        // drill down，先递归，然后汇总到root
        root.left = recursive(nums, left, mid - 1);
        root.right = recursive(nums, mid + 1, right);

        // reverse current states
        return root;
    }

    private Random random = new Random();

    public TreeNode sortedArrayToBSTPlusPlus(int[] nums) {
        // Clarification: 有序数组，转成平衡二叉树
        // 方案1: 二分法 + 递归，选择中间位置左边的数字作为根节点
        // 递归参数: 数组，左，右
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (nums == null || nums.length == 0) {
            return null;
        }

        return recursive3(nums, 0, nums.length - 1);
    }

    private TreeNode recursive3(int[] nums, int left, int right) {
        // terminator
        if (left > right) {
            return null;
        }

        // process current logic
        // 随机选择中间位置左、右边的节点作为根节点
        int mid = (left + right + random.nextInt(2)) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        // drill down，先递归，然后汇总到root
        root.left = recursive(nums, left, mid - 1);
        root.right = recursive(nums, mid + 1, right);

        // reverse current states
        return root;
    }
}
