package com.jemmy.algorithm.everyday;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/21
 */
public class TwoSumIIInputArrayIsSorted_167 {

    public int[] twoSum(int[] numbers, int target) {
        // Clarification: 升序数组，找出两个数，等于target
        // 方案1：双指针，分别指向开始和结束位置，然后判断哪个需要移动
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] {-1, -1};
    }

    public int[] twoSumTwo(int[] numbers, int target) {
        // 方案2：循环，针对每个数，从右边位置进行二分查找
        // 时间复杂度: O(nlogn)
        // 空间复杂度: O(1)

        for (int i = 0; i < numbers.length - 1; i++) {
            // 从右边进行二分查找
            int another = target - numbers[i];
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (numbers[mid] == another) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < another) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[] {-1, -1};
    }
}
