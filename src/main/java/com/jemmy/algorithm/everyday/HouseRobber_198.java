package com.jemmy.algorithm.everyday;

/**
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/12
 */
public class HouseRobber_198 {

    public int rob(int[] nums) {
        // Clarification: 相邻的房屋不能偷，求能偷到的最高金额
        // 方案1: 动态规划
        // 状态: dp[i]，到第i间房屋，能偷到的最高金额
        // 状态转移方程: dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];
    }

    public int robTwo(int[] nums) {
        // 方案2: 动态规划 + 滚动数组
        // 状态简化: dp[i] 只和数组前面两个元素有关，定义为 first, second
        // 状态转移方程: curr = max(second, first + nums[i])
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(first, nums[1]);

        for (int i = 2; i < len; i++) {
            int temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }

        return second;
    }

}
