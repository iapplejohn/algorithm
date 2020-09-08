package com.jemmy.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 *
 * @author zhujiang.cheng
 * @since 2020/6/14
 */
public class Find132Pattern {

    public boolean find132pattern(int[] nums) {
        // 方案1: 3个指针，依次遍历，时间复杂度O(N^3)
        // 在数组很大的时候，执行时间过长
        if (nums == null || nums.length < 3) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern_2(int[] nums) {
        // 方案2: 前缀最小数组+递减栈
        // 前缀最小数组: 从这里拿i
        // 递减栈: 从这里拿k
        // 然后从右到左遍历
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        if (nums == null || nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > min[j]) {
                while (stack.size() > 0 && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (stack.size() > 0 && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find132Pattern instance = new Find132Pattern();
//        int[] nums = {6, 12, 3, 4, 6, 11, 20};
        int[] nums = {3, 1, 4, 2};
        System.out.println(instance.find132pattern_2(nums));
    }
}
