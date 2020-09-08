package com.jemmy.algorithm.everyday;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/23
 */
public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        // Clarification: 最大和的连续子数组
        // 方案1：双重循环
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(1)

        if (nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public int maxSubArrayTwo(int[] nums) {
        // 方案2：动态规划
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        if (nums.length == 0) {
            return 0;
        }

        // 和最大值: 初始为第一个元素值
        int maxSum = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 之前和最大值 + 当前值
            int sum = curMax + nums[i];
            // 比较当前和最大值 和 当前值 谁大
            curMax = Math.max(sum, nums[i]);
            if (curMax > maxSum) {
                maxSum = curMax;
            }
        }

        return maxSum;
    }

    public int maxSubArrayThree(int[] nums) {
        // 方案3：分治法 TODO
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)
        return 0;

    }
}

