package com.jemmy.algorithm.leetcode;

/**
 * 941. 有效的山脉数组
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/3
 */
public class ValidMountainArray_941 {

    public boolean validMountainArray(int[] A) {
        // Clarification: 数组为递增、递减序列，中间不能出现相等情况
        // 方案1：简单的一次遍历

        if (A.length < 3) {
            return false;
        }

        // 是否包含递增序列
        boolean hasIncreasing = false;

        // 是否包含递减序列
        boolean hasDecreasing = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            } else if (A[i] > A[i - 1]) {
                // 如果处在递减状态，还有递增的情况
                if (hasDecreasing) {
                    return false;
                }
                hasIncreasing = true;
            } else {
                // 没有递增序列，直接递减
                if (!hasIncreasing) {
                    return false;
                }
                hasDecreasing = true;
            }
        }

        return hasDecreasing;
    }

    public boolean validMountainArrayTwo(int[] A) {
        // 方案2：模拟法 找到最高点位置，判断是否第一个或最后一个位置，然后检查递减序列

        int i = 0, len = A.length;

        // 寻找最大值的位置
        while (i < len - 1 && A[i] < A[i + 1]) {
            i++;
        }

        // 最大值在第一个或最后一个位置，不符合要求
        if (i == 0 || i == len - 1) {
            return false;
        }

        // 判断后续是否递减序列
        while (i < len - 1 && A[i] > A[i + 1]) {
            i++;
        }

        return i == len - 1;
    }

    public boolean validMountainArrayThree(int[] A) {
        // 方案3: 双指针法 从左右两端分别爬，在某个点相遇，该点不能为左右两端

        int len = A.length;
        int i = 0, j = A.length - 1;

        // 左指针爬山
        while (i < len - 1 && A[i] < A[i + 1]) {
            i++;
        }

        // 右指针爬山
        while (j >= 1 && A[j] < A[j - 1]) {
            j--;
        }

        if (i != 0 && i == j && j < len - 1) {
            return true;
        }

        return false;
    }
}
