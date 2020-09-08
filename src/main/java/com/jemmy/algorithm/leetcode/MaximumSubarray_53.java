package com.jemmy.algorithm.leetcode;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/6
 */
public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        // Clarification: 具有最大值的连续子数组
        // 方案1: 暴力，遍历子数组的起始和结束位置
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(1)

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public int maxSubArrayTwo(int[] nums) {
        // 方案2: 动态规划
        // 相似子问题: 前一个最大值
        // 状态定义: dp[i] 当前最大值
        // 状态转移方程: dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i]
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArrayTwoPlus(int[] nums) {
        // 方案2: 动态规划 + 简化状态数组
        // 相似子问题: 前一个最大值
        // 状态定义: prev 之前最大值
        // 状态转移方程: curr = prev > 0 ? prev + nums[i] : nums[i]
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int prev = nums[0], curr;
        int max = prev;
        for (int i = 1; i < nums.length; i++) {
            if (prev > 0) {
                curr = prev + nums[i];
            } else {
                curr = nums[i];
            }

            max = Math.max(max, curr);
        }

        return max;
    }

    // 方案3: 分治

}
