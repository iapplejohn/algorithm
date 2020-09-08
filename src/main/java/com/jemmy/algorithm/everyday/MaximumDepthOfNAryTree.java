package com.jemmy.algorithm.everyday;

/**
 * 559. N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/17
 */
public class MaximumDepthOfNAryTree {

    public int maxDepth(Node root) {
        // Clarification: N 叉树的最大深度
        // 方案1：递归

        // terminator
        if (root == null) {
            return 0;
        }

        // process current
        int maxDepth = 0;

        // drill down
        // 求子树的最大深度
        if (root.children != null) {

            for (Node child : root.children) {
                int depth = maxDepth(child);
                maxDepth = Math.max(depth, maxDepth);
            }
        }

        // 当前树的最大深度上报
        return maxDepth + 1;
    }

    public int maxDepthTwo(Node root) {
        // 方案2：迭代 + 栈辅助 TODO
        return 0;
    }

}
