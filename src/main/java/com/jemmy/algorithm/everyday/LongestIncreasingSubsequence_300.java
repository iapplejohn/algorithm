package com.jemmy.algorithm.everyday;

import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/20
 */
public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        // Clarification: 最长上升子序列
        // 方案1：动态规划
        // 状态定义: dp[i]，考虑前i个元素，以第i个数字结尾的最长上升子序列的长度
        // 状态转移方程: dp[i] = max(dp[j]) + 1，其中 0 <= j < i 且 num[j] < num[i]
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)，使用了 dp 数组

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxlis = dp[0];
        // 从前往后，记录每个位置的 LIS
        for (int i = 1; i < nums.length; i++) {
            int subLis = 0;
            // 拿之前的元素 和 i 比较，小于为候选值，比较后获取当前位置之前的最大 LIS
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    subLis = Math.max(subLis, dp[j]);
                }
            }

            // 加 1 为当前位置的最大 LIS
            dp[i] = subLis + 1;
            // 获取全局最大的 LIS
            maxlis = Math.max(maxlis, dp[i]);
        }

        return maxlis;
    }

    public int lengthOfLISTwo(int[] nums) {
        // 方案2: 贪心 + 二分查找 TODO 运行报错
        // 我们要使上升序列尽可能的长，需要让序列上升得尽可能慢，因此子序列最后加上的数尽可能的小
        // 维护一个 LIS 数组，从前往后遍历 nums
        // 如果当前元素大于LIS数组最后一个值，直接加入到数组末尾
        // 否则在 LIS 数组中二分查找，找到第一个比当前元素小的数，覆盖后一位的值

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>(len + 1);
        Collections.fill(list, 0);
        list.add(nums[0]);
        int maxLis = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > list.get(maxLis - 1)) {
                list.add(nums[i]);
                maxLis++;
            } else {
                int l = 1, r = list.size() - 1, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (list.get(mid) < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                list.set(pos + 1, nums[i]);
            }
        }

        return maxLis;
    }
}
