package com.jemmy.algorithm.everyday;

/**
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/2
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        // Clarification: 旋转排序数组，搜索目标值
        // 方案1：暴力

        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public int searchTwo(int[] nums, int target) {
        // 方案2：二分查找（变形）
        // 二分后，旋转有序数组左侧或右侧有序，判断 target 是否在这个范围中，不在则选择另一侧

        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) { // 右侧有序
                if (nums[right] == target) {
                    return right;
                }

                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 左侧有序
                if (nums[left] == target) {
                    return left;
                }

                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
