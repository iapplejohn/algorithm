package com.jemmy.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author zhujiang.cheng
 * @since 2020/6/17
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        // 方案1：递归，
        // 二叉搜索树的特性，左子树的每个节点值都小于当前节点
        // 右子树的每个节点值都大于当前节点，在处理每个节点时，
        // 需要知道节点不能大于某个值，不能小于某个值
        // 1. 不能只关注父节点，作为左/右子树，还要关注父的父节点，所以限界值要带过来
        // 2. 两种方案：
        // 下探：比较当前节点和子节点的值
        // 指标：向子节点下指标，不能低于/高于某个值
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        // terminator
        if (node == null) {
            return true;
        }

        // process current loop
        int current = node.val;
        if (lower != null && lower >= current) {
            return false;
        }
        if (upper != null && upper <= current) {
            return false;
        }

        // drill down
        boolean valid = true;
        if (node.left != null) {
            valid = helper(node.left, lower, current);
        }
        if (node.right != null) {
            valid = valid && helper(node.right, current, upper);
        }

        // clean the cache
        return valid;
    }

    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();

    public boolean isValidBST_2(TreeNode root) {
        // 方案2：迭代，
        // 通过栈来辅助，同时存限界值
        // 1. 存入根节点
        // 2. 然后从栈拿对象，判断当前节点是否满足要求，往栈push子节点
        // 3. 重复2
        update(root, null, null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower = lowers.poll();
            Integer upper = uppers.poll();

            if (node == null) {
                continue;
            }

            Integer current = node.val;
            if (lower != null && current <= lower) {
                return false;
            }
            if (upper != null && current >= upper) {
                return false;
            }

            if (node.right != null) {
                update(node.right, current, upper);
            }
            if (node.left != null) {
                update(node.left, lower, current);
            }
        }

        return true;
    }

    private void update(TreeNode node, Integer lower, Integer upper) {
        stack.push(node);
        lowers.push(lower);
        uppers.push(upper);
    }

    public boolean isValidBST_3(TreeNode root) {
        // 方案3：中序遍历，TODO
        // 通过栈来辅助，同时存限界值
        // 1. 存入根节点
        // 2. 然后从栈拿对象，判断当前节点是否满足要求，往栈push子节点
        // 3. 重复2
        update(root, null, null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower = lowers.poll();
            Integer upper = uppers.poll();

            if (node == null) {
                continue;
            }

            Integer current = node.val;
            if (lower != null && current <= lower) {
                return false;
            }
            if (upper != null && current >= upper) {
                return false;
            }

            if (node.right != null) {
                update(node.right, current, upper);
            }
            if (node.left != null) {
                update(node.left, lower, current);
            }
        }

        return true;
    }
}
