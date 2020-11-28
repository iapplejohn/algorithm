package com.jemmy.algorithm.leetcode.dp;

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
 * @since 2020/11/8
 */
public class BestTimeToBuyAndSellStockII_122 {

    public int maxProfit(int[] prices) {
        // Clarification: 股票交易，已知每天的价格，求最大利润
        // 方案1：一次遍历法，增加收益就购买

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }

    public int maxProfitTwo(int[] prices) {
        // 方案2：贪心法，寻找紧邻的峰谷，求其差值

        int max = 0;
        int i = 0, len = prices.length;
        while (i < len - 1) {
            // 寻找谷 [3,3]输入，需要加等于号，否则无限循环
            while (i < len - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }

            int vally = prices[i];

            // 寻找峰 加等于号，原因同上
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];

            max += (peak - vally);
        }

        return max;
    }

    public int maxProfitThree(int[] prices) {
        // 方案3：动态规划 TODO

        return 0;
    }
}
