package com.jemmy.algorithm.leetcode.dfs;

/**
 * LCP 19. 秋叶收藏集
 *
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UlBDOe
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/1
 */
public class UlBDOe {

    public int minimumOperations(String leaves) {
        // Clarification: 将树叶调整（替换）成红黄红三部分，每部分数量可以不相等，但均需大于1，求最小调整次数
        // 方案1: 动态规划
        // 状态定义：dp[i][j] i: 叶子从0到i，j：0-第一部分红，1-第二部分黄，2-第三部分红
        // 状态转移方程：
        // dp[i][0] = dp[i - 1][0] + isYellow(i)
        // dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + isRed(i)
        // dp[i][2] = min(dp[i - 1][1], dp[i - 1][2]) + isYellow(i)，i - 1不能为第一部分
        // 边界条件: dp[0][0] = dp[0 - 1][0] (没意义，可以认为0) + isYellow(0) = isYellow(0)
        // dp[0][1], dp[0][2], dp[1][2] 都不符合条件，设置为整型最大值

        int len = leaves.length();
        int[][] dp = new int[len][3];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            int yellowVal = leaves.charAt(i) == 'y' ? 1 : 0;
            int redVal = leaves.charAt(i) == 'r' ? 1 : 0;

            dp[i][0] = dp[i - 1][0] + yellowVal;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + redVal;
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + yellowVal;
            }
        }

        return dp[len - 1][2];
    }

    public int minimumOperationsTwo(String leaves) {
        // 方案2：前缀和 + 动态规划 TODO

        return 0;
    }
}
