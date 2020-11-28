package com.jemmy.algorithm.leetcode.bag;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/12
 */
public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        // Clarification: 将只包含正整数的非空数组，拆成和相等的两个子集
        // 方案1: 动态规划 总和必须为偶数
        // 状态定义: dp[i][target] 表示由 0...nums[i] 全部（部分）组成的和，是否为target
        // 状态转移方程：dp[i][target]
        // = true, nums[i] == target
        // = nums[i - 1][target] || nums[i - 1][target - nums[i]]，nums[i] < j, 0...i-1的和等于 target 或 target - nums[i]

        int sum = 0;

        // 先求出总和
        for (int num : nums) {
            sum += num;
        }

        // 如果为奇数，不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        // 总和的一半，即为target
        int target = sum >> 1;

        boolean[][] dp = new boolean[nums.length][target + 1];

        // 先填充第一行
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 先从上一行拷贝数据
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }

}
