package com.jemmy.algorithm.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2 输出: 5 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 输出: 4 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/13
 */
public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        // Clarification: 无序数组，找第k个最大的元素
        // 方案1：排序 + 计数到k

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public int findKthLargestTwo(int[] nums, int k) {
        // 方案2：小顶堆, PriorityQueue

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        KthLargestElementInAnArray_215 instance = new KthLargestElementInAnArray_215();
        System.out.println(instance.findKthLargestTwo(nums, 2));
    }
}
