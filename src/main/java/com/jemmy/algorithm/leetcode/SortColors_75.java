package com.jemmy.algorithm.leetcode;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/8
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {
        // Clarification: 排序红、白和蓝3种颜色，分别以0、1和2分别表示
        // 方案1: 计数排序，然后重写当前数组
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int red = 0, white = 0, blue = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int j = 0; j < white; j++) {
            nums[red + j] = 1;
        }

        for (int k = 0; k < blue; k++) {
            nums[red + white + k] = 2;
        }
    }

    public void sortColorsTwo(int[] nums) {
        // 方案2: 双指针 分别指向无序开始和结束位置
        // 当前索引，遇到0和无序开始位置交换，遇到1不需交换，遇到2和无序结束位置交换

        int begin = 0, end = nums.length - 1, curr = 0;
        // 注意不要漏了 curr == end 这种情况，因为 end 是无序的，可能需要处理
        while (curr <= end) {
            if (nums[curr] == 0) {
                if (curr != begin) {
                    swap(nums, begin, curr);
                }
                begin++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, end, curr);
                end--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        SortColors_75 inst = new SortColors_75();
        inst.sortColors(new int[] {2});
    }

}
