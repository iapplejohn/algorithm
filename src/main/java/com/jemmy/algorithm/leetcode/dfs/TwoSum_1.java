package com.jemmy.algorithm.leetcode.dfs;

import java.util.HashMap;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/3
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        // Clarification: 两数相加，和为指定值，找到一个答案即可
        // 方案1: 两重循环
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(1)

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }

    public int[] twoSumTwo(int[] nums, int target) {
        // 方案2: 哈希表 将所有值和下标放到哈希表中，然后对每个值，判断 target-值是否存在哈希表中，且不是当前元素

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int another = target - nums[j];
            if (map.containsKey(another) && map.get(another) != j) {
                return new int[]{j, map.get(another)};
            }
        }

        return new int[] {};
    }

    public int[] twoSumThree(int[] nums, int target) {
        // 方案3: 一遍哈希法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[] {i, map.get(another)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
