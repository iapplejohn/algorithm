package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author zhujiang.cheng
 * @since 2020/6/6
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 方案1：使用List记录不重复的元素
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) != nums[i]) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }

    public int removeDuplicates_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 方案2：使用双指针
        int previous = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[previous]) {
                if (++previous != i) {
                    nums[previous] = nums[i];
                }
            }
        }

        return previous + 1;
    }

}
