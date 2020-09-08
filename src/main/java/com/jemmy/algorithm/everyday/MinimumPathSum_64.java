package com.jemmy.algorithm.everyday;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/27
 */
public class MinimumPathSum_64 {

    private int[][] cache;

    public int minPathSum(int[][] grid) {
        // Clarification: 最小路径之和

        // 方案1：递归
        int m = grid.length, n = grid[0].length;
        cache = new int[m][n];

        return recursive(grid, m - 1, n - 1);
    }

    public int recursive(int[][] grid, int i, int j) {
        // terminator
        if (i < 0 || j < 0) {
            return 0;
        }

        // process current logic
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        // drill down
        int prevSum;
        if (i == 0 && j == 0) {
            prevSum = 0;
        } else if (i == 0 && j > 0) {
            prevSum = recursive(grid, i, j - 1);
        } else if (i > 0 && j == 0) {
            prevSum = recursive(grid, i - 1, j);
        } else {
            int sum1 = recursive(grid, i, j - 1);
            int sum2 = recursive(grid, i - 1, j);
            prevSum = Math.min(sum1, sum2);
        }

        cache[i][j] = prevSum + grid[i][j];

        return cache[i][j];
    }

    public int minPathSumTwo(int[][] grid) {
        // 方案2：动态规划，两维数组保存每个位置最短路径值
        // 时间复杂度: O(n * m)
        // 空间复杂度: O(n * m)

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minPathSumTwoPlus(int[][] grid) {
        // 方案2：动态规划，一维数组保存每个位置最短路径值，长度为列的数量
        // 每次处理一行上的元素
        // 时间复杂度: O(n * m)
        // 空间复杂度: O(n)

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        // 处理第一行数据
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // 处理其他行数据
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 第一列单独处理：上一行的值 + 当前单元格的值
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    // 其他列：当前行的上一列 和 当前列的上一行 取较小值 + 当前单元格的值
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] array = new int[2][8];
        System.out.println(array[0][1]);
    }
}
