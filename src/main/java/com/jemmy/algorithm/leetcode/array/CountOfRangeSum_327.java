package com.jemmy.algorithm.leetcode.array;

/**
 * 327. 区间和的个数
 *
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/7
 */
public class CountOfRangeSum_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        // Clarification: 某个区间元素之和在限定范围内的个数
        // 方案1：对区间起终点进行遍历
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(1)

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= lower && nums[i] <= upper) {
                count++;
            }

            // sum 定义为 long 类型，否则当元素比较大时会溢出
            long sum = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }
}
