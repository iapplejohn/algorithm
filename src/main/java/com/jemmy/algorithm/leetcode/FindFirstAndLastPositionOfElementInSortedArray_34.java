package com.jemmy.algorithm.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/19
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        // Clarification: 排序数组，查找元素的第一个和最后一个位置
        // 方案1：直接遍历
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int[] res = new int[2];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                }
                // 可能多次覆盖，最终为最后一个位置
                res[1] = i;
            }
        }

        return res;
    }

    public int[] searchRangeTwo(int[] nums, int target) {
        // 方案2：二分法，先找到目标元素，然后向左向右寻找
        // 时间复杂度: O(Log2N)
        // 空间复杂度: O(1)

        int left = 0, right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                pos = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int[] res = new int[2];
        res[0] = pos;
        res[1] = pos;

        int i = pos;
        while (--i >= 0) {
            if (nums[i] == target) {
                res[0] = i;
            } else {
                break;
            }
        }

        while (++pos <= nums.length - 1) {
            if (nums[pos] == target) {
                res[1] = pos;
            } else {
                break;
            }
        }

        return res;
    }
}
