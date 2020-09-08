package com.jemmy.algorithm.everyday;

/**
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/15
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // Clarification: 能组成几种二叉搜索树 卡塔兰数
        // n个节点存在二叉排序树的个数是G(n)
        // G(n) = 1为根 + 2为根 + ... + n为根
        // 当i为根节点时，其左子树节点个数为 i - 1，右子树节点个数为 n - i，则
        // 二叉搜索树个数 = G(i - 1) * G(n - i)，相当于笛卡尔积

        // G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
        // 方案1：动态规划
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // 第一重循环: i为节点个数，寻找该情况下可能性
        for (int i = 2; i <= n; i++) {
            // 第二种循环：j为根节点，可以为1、2 ... i
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public int numTreesTwo(int n) {
        // 方案2：数学 TODO

        return 0;
    }
}
