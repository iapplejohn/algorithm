package com.jemmy.algorithm.leetcode.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/28
 */
public class BestTimeToBuyAndSellStockII_122 {

    public int maxProfitTwo(int[] prices) {
        // Clarification: 获取最大利润，可以多次买卖，不能同时参与多笔交易
        // 方案2: 贪心算法，寻找紧邻的峰谷，求差值之和

        int i = 0, len = prices.length, maxProfit = 0;
        while (i < len - 1) {
            // 寻找谷
            while (i < len - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            int vally = prices[i];

            // 寻找峰
            while (i < len - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            int peak = prices[i];

            // 累加每个峰谷的差值，即为最大利润
            maxProfit += (peak - vally);
        }

        return maxProfit;
    }

    public int maxProfitThree(int[] prices) {
        // 方案3: 简单的一次遍历，在方案2的基础上，峰谷的差值，等于峰与谷之间每个差值之和
        // 只要当天比前一天高，就买入

        int i = 1, maxProfit = 0;
        while (i < prices.length) {
            // 当天比前一天高，买入
            if (prices[i - 1] < prices[i]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
            i++;
        }

        return maxProfit;
    }

    public int maxProfitFour(int[] prices) {
        // 方案4: 动态规划
        // dp[i][k][0 or 1]: i - 第i天，0-不持有，1-持有，交易次数不限
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
        // = max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i])
        // k 不会发生改变, 降维
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 1) {
                // dp[0][0] = max(dp[-1][0], dp[-1][1] + prices[i]) = 0
                dp[i][0] = 0;

                // dp[0][1] = max(dp[-1][1], dp[-1][0] - prices[i]) = -prices[i]
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 不持有(卖出)利润最高
        return dp[n - 1][0];
    }

    public int maxProfitFourPlus(int[] prices) {
        // 方案4': 动态规划 + 空间压缩
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        // 不持有(卖出)利润最高
        return dp_i_0;
    }
}
