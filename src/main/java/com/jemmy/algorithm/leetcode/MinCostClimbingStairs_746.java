package com.jemmy.algorithm.leetcode;

/**
 * 746. 使用最小花费爬楼梯
 *
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/22
 */
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        // Clarification: 最低花费，每次爬一个阶梯或二个阶梯
        // 方案1: 动态规划 从前往后
        // dp[i]: 代表到达i位置顶部最低花费
        // dp[i] = min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1])
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int[] minCost = new int[cost.length];
        minCost[0] = 0;
        minCost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 1], minCost[i - 1] + cost[i]);
        }

        return minCost[cost.length - 1];
    }

    public int minCostClimbingStairsPlus(int[] cost) {
        // 方案1': 动态规划 从前往后
        // 空间利用上优化，用两个变量保存状态转移方程中前面的两个记录
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int len = cost.length;
        int minCost0 = 0;
        int minCost1 = Math.min(cost[0], cost[1]);
        int minCost = 0;

        for (int i = 2; i < len; i++) {
            minCost = Math.min(minCost0 + cost[i - 1], minCost1 + cost[i]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }

        return minCost;
    }

    public int minCostClimbingStairsTwo(int[] cost) {
        // 方案2: 动态规划 求 到达 i - 1 和 i 之间的最小值
        // dp[i]: 到达i位置的最低花费
        // dp[i] = min(dp[i], dp[i - 1]) + cost[i]
        // 和方案1中的dp 不同

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0] + cost[1], cost[1]);

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    public int minCostClimbingStairsTwoPlus(int[] cost) {
        // 方案2': 优化空间占用，将前面两个作为变量
        int dp0 = cost[0];
        int dp1 = Math.min(dp0 + cost[1], cost[1]);

        for (int i = 2; i < cost.length; i++) {
            int dpCur = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = dpCur;
        }

        return Math.min(dp0, dp1);
    }

}
