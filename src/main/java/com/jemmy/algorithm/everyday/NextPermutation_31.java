package com.jemmy.algorithm.everyday;

/**
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/7
 */
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        // Clarification: 找到比当前数组表示的数大一点点的排列
        // 从数组右边开始，找到第一对a[i]和a[i + 1]，使得a[i] < a[i + 1]
        // 找一个更大的数字放到i位置上，使得数字更大
        // 很明显，从i + 1到末尾，找一个数a[j]，刚好比a[i]大一点，交换a[i]和a[j]
        // i位置上的数对了，但数字还不是最小的
        // i + 1到末尾之前是降序，反转后变为升序
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 上面的循环，可能找不到这样的位置，i就为-1了，说明当前是最大的数，下一个就是最小的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        int left = i + 1;
        int right = nums.length - 1;
        reverse(nums, left, right);

    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
