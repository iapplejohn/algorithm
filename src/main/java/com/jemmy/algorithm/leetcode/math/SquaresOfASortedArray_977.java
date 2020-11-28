package com.jemmy.algorithm.leetcode.math;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/16
 */
public class SquaresOfASortedArray_977 {

    public int[] sortedSquares(int[] A) {
        // Clarification: 输入为递增排序数组，返回每个数字的平方组成的新递增排序数组
        // 方案1: 模拟法，先求平方，后排序
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(logN)

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }

        Arrays.sort(res);
        return res;
    }

    public int[] sortedSquaresTwo(int[] A) {
        // 方案2: 二分法，先找到正负分界点，然后向左向右求平方，归并排序
        // 时间复杂度: O(N)
        // 空间复杂度: O(1)

        int len = A.length, neg = -1;

        // 找到最后一个负数
        for (int i = 0; i < len; i++) {
            if (A[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }

        int[] res = new int[len];
        int index = 0, i = neg, j = neg + 1;
        while (i >= 0 || j < len) {
            if (i < 0) {
                res[index] = A[j] * A[j];
                j++;
            } else if (j == len) {
                res[index] = A[i] * A[i];
                i--;
            } else if (A[i] * A[i] > A[j] * A[j]) {
                res[index] = A[j] * A[j];
                j++;
            } else {
                res[index] = A[i] * A[i];
                i--;
            }
            index++;
        }

        return res;
    }

    public int[] sortedSquaresThree(int[] A) {
        // 方案3: 二分法 平方最大值产生于首尾，取最大值放到新数组的末尾
        // 时间复杂度: O(N)
        // 空间复杂度: O(1)

        int len = A.length, left = 0, right = len - 1, pos = len - 1;
        int[] res = new int[len];

        // 不要漏了 left 和 right 相等的情况
        while (left <= right) {
            int sl = A[left] * A[left], s2 = A[right] * A[right];
            if (sl > s2) {
                res[pos] = sl;
                left++;
            } else {
                res[pos] = s2;
                right--;
            }
            pos--;
        }

        return res;
    }
}
