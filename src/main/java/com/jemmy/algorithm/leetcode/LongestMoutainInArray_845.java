package com.jemmy.algorithm.leetcode;

/**
 * 845. 数组中的最长山脉
 *
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/25
 */
public class LongestMoutainInArray_845 {

    public int longestMountain(int[] A) {
        // Clarification: 最长的山脉，最短3个数，先递增再递减
        // 方案1: 模拟法 找到递增的起点，然后找到递增的终点，将该长度和最大值进行比较

        int res = 0, i = 1, len = A.length;
        int start = -1;

        while (i < len) {
            while (A[i] <= A[i - 1]) {
                i++;
                if (i == len) {
                    return res;
                }
            }

            if (A[i] > A[i - 1]) {
                start = i - 1;
                i++;
                while (i < len && A[i] > A[i - 1]) {
                    i++;
                }
                while (i < len && A[i] < A[i - 1]) {
                    i++;
                }
                res = Math.max(res, i - start);
            }
        }

        return res;
    }

    public int longestMountainTwo(int[] A) {
        // 方案1'：简单的一次遍历

        if (A.length < 3) {
            return 0;
        }

        int res = 0, start = -1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                // 这里 A[i - 2] 和 A[i - 1] 相等的情形
                if (i == 1 || A[i - 2] >= A[i - 1]) {
                    start = i - 1;
                }
            } else if (A[i] < A[i - 1]) {
                if (start != -1) {
                    res = Math.max(res, i - start + 1);
                }
            } else {
                // 和前面值相等，需要重置 start
                start = -1;
            }
        }

        return res;
    }
}
