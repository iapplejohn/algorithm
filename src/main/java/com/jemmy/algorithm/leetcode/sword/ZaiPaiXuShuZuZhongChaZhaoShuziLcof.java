package com.jemmy.algorithm.leetcode.sword;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 *  
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/19
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuziLcof {

    public int search(int[] nums, int target) {
        // Clarification: 统计一个数字在排序数组中出现的次数
        // 方案1: 直接遍历
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }

        return count;
    }

    public int searchTwo(int[] nums, int target) {
        // 方案2: 二分法，找到目标数字后，再往左往右寻找
        // 时间复杂度: O(Log2N)
        // 空间复杂度: O(1)

        int count = 0, pos = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                count++;
                pos = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int i = pos;
        while (--i >= 0) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }

        while (++pos <= nums.length - 1) {
            if (nums[pos] == target) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
