package com.jemmy.algorithm.leetcode.greedy;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/29
 */
public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit(int[] prices) {
        // Clarification: 完成一次交易，获取最大利润
        // 方案1: 暴力 双重循环，寻找两个元素
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(1)

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    continue;
                }
                // 只交易一次（买入和卖出一支股票一次）
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public int maxProfitTwo(int[] prices) {
        // 方案2: 一次遍历，找到最低值，然后计算最大差额
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int subtract = prices[i] - minPrice;
                if (subtract > maxProfit) {
                    maxProfit = subtract;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfitThree(int[] prices) {
        // 方案3: 动态规划
        // 状态定义: dp[i][k][0 or 1] // i - 第i天, k - 买了几次, 0 - 未持有, 1 - 持有
        // 状态转移方程
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
        // 当 k = 1 时（只交易一次）
        // dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
        // dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i])
        // = max(dp[i - 1][1][1], -prices[i])
        // 第二维都为1，降维
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = max(dp[i - 1][1], -prices[i])
        // base case (i = 0)
        // dp[0][0] = max(dp[-1][0], dp[-1][1] + prices[i]) = 0
        // dp[0][1] = max(dp[-1][1], -prices[i]) = -prices[i]
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int i = 0 ; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        // 不持有(卖出)利润最高
        return dp[n - 1][0];
    }

    public int maxProfitThreePlus(int[] prices) {
        // 方案3': 动态规划 + 优化状态空间
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i - 1][1], -prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        // 不持有(卖出)利润最高
        return dp_i_0;
    }
}
