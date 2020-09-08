package com.jemmy.algorithm.everyday;

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *  
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/18
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        // Clarification: 有多少种不同的走法，只能向下或向右
        // 方案1: 动态规划，自底向上

        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = 1;
                } else {
                    dp[r][c] = 0;
                    if (r > 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
                    if (c > 0) {
                        dp[r][c] += dp[r][c - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsPlus(int m, int n) {
        // 方案2: 动态规划，自底向上，优化 TODO
        return 0;
    }

    public int uniquePathsPlusPlus(int m, int n) {
        // 方案2: 动态规划，自底向上，优化 TODO
        return 0;
    }
}
