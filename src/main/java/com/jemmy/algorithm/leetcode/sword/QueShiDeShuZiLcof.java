package com.jemmy.algorithm.leetcode.sword;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/9
 */
public class QueShiDeShuZiLcof {

    public int missingNumber(int[] nums) {
        // Clarification: 递增排序数组，只有一个数字不在数组中，找出这个数字
        // 方案1: 位置和数值关联，如果位置小于数值，数值减1即为缺失数

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > i) {
                return nums[i] - 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    public int missingNumberTwo(int[] nums) {
        // 方案2: 自增判断，如果自增值小于当前位置值，自增值即为缺失数

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                return target;
            }
            target++;
        }

        return target;
    }

    public int missingNumberThree(int[] nums) {
        // 方案3: 二分法

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
