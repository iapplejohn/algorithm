package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/3
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        // Clarification: 将所有0移到末尾，保持非零元素相对顺序，不能拷贝额外数组
        // 方案1: 列表暂存非0元素，然后放回数组中，后面位置置0
        if (nums == null || nums.length <= 1) {
            return;
        }

        List<Integer> nonZeroList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroList.add(nums[i]);
            }
        }

        int j = 0;
        for (; j < nonZeroList.size(); j++) {
            nums[j] = nonZeroList.get(j);
        }

        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public void moveZeroesTwo(int[] nums) {
        // 方案2: 双指针，一个指向下一个非0放置位置，另一个为当前位置

        if (nums == null || nums.length <= 1) {
            return;
        }

        int nonZeroPos = 0, curr = 0;

        while (curr < nums.length) {
            if (nums[curr] != 0) {
                if (curr != nonZeroPos) {
                    nums[nonZeroPos] = nums[curr];
                }
                nonZeroPos++;
            }
            curr++;
        }

        for (int i = nonZeroPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesThree(int[] nums) {
        // 方案3: 双指针 + 交换
        // 当前如果是非0元素，和非0元素待放位置互换(该位置和当前索引之间的值都为0)，两个指针都自增；否则当前指针自增
        // 时间复杂度: O(n)，比方案2好，最坏情况下和方案2一致
        // 空间复杂度: O(1)

        if (nums == null || nums.length <= 1) {
            return;
        }

        int nextNonZeroPos = 0, curr = 0;
        for (; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                if (curr != nextNonZeroPos) {
                    swap(nums, curr, nextNonZeroPos);
                }
                nextNonZeroPos++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
