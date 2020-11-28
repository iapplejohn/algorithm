package com.jemmy.algorithm.leetcode.array;

/**
 * 493. 翻转对
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/28
 */
public class ReversePairs_493 {

    public int reversePairs(int[] nums) {
        // Clarification: i < j 且 nums[i] >  2 * nums[j]，称作一个重要翻转对，求个数
        // 方案1：暴力 超出时间限制

        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 乘以 2 溢出
                int half = nums[i] >> 1;
                if (half > nums[j] || (half == nums[j] && (nums[i] & 1) == 1)) {
                    res++;
                }
            }
        }

        return res;
    }

    public int reversePairsTwo(int[] nums) {
        // 归并排序 求分别两个部分的数量，累加，然后两个部分之间的数量，归并排序
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(N)

        if (nums.length <= 1) {
            return 0;
        }

        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right) {
        // terminator
        if (left == right) {
            return 0;
        }

        // process current logic
        // drill down
        int mid = (left + right) >> 1;
        int n1 = reversePairsRecursive(nums, left, mid);
        int n2 = reversePairsRecursive(nums, mid + 1, right);
        int n = n1 + n2;

        // 处理两个排序子数组之间的翻转对
        int i = left, j = mid + 1;
        while (i <= mid) {
            // 针对每个i，找出临界点，之前的 j 都满足翻转对条件
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            n += j - mid - 1;
            // 下一个 i，至少能 cover 上个 i 的翻转对数目
            i++;
        }

        // 归并排序，声明数组保存排序后的元素
        int[] array = new int[right - left + 1];
        // 三个指针：左子数组、右子数组、排序数组
        int p1 = left, p2 = mid + 1, p0 = 0;
        // 只要 左、右子数组还有元素，涵盖三种情况
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                array[p0++] = nums[p2++];
            } else if (p2 > right) {
                array[p0++] = nums[p1++];
            } else {
                if (nums[p1] > nums[p2]) {
                    array[p0++] = nums[p2++];
                } else {
                    array[p0++] = nums[p1++];
                }
            }
        }

        // 写回原数组，方便后面的处理
        for (int k = 0; k < array.length; k++) {
            nums[left + k] = array[k];
        }

        // reverse current states

        return n;
    }
}
