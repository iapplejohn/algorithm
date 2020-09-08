package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
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
 *
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 方案1: 使用List记录非0元素，使用count记录0元素个数
        // 将非0元素和0放回原数组
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j < list.size()) {
                nums[j] = list.get(j);
            } else {
                nums[j] = 0;
            }
        }
    }

    public void moveZeroes_2(int[] nums) {
        // 方案2: 双指针，慢的指向第一个待替换位置，快的为当前位置，0的个数
        if (nums.length <= 1) {
            return;
        }

        int count = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (pos != i) {
                    nums[pos] = nums[i];
                }
                pos++;
            }
        }

        if (count > 0) {
            for (int j = nums.length - count; j < nums.length; j++) {
                nums[j] = 0;
            }
        }
    }

    public void moveZeroes_22(int[] nums) {
        // 方案22: 双指针，慢的指向第一个待替换位置，快的为当前位置
        if (nums.length <= 1) {
            return;
        }

        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (last != i) {
                    nums[last] = nums[i];
                }
                last++;
            }
        }

        if (last > 0) {
            for (int j = last; j < nums.length; j++) {
                nums[j] = 0;
            }
        }
    }

    public void moveZeroes_3(int[] nums) {
        // 当前如果是非0元素，和非0元素待放位置互换(该位置和当前索引之间的值都为0)，两个指针都自增；否则当前指针自增
        // 时间复杂度: O(n)，比方案2好，最坏情况下和方案2一致
        // 空间复杂度: O(1)

        if (nums == null || nums.length <= 1) {
            return;
        }

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (p != i) {
                    swap(nums, p, i);
                }
                p++;
            }
        }
    }

    private void swap(int[] nums, int p, int i) {
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
    }
}
