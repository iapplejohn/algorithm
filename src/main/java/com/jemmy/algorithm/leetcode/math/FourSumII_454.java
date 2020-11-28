package com.jemmy.algorithm.leetcode.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/27
 */
public class FourSumII_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Clarification: 四个数相加和为0，求满足条件的组合个数
        // 方案1：暴力法 - 多重循环 超出时间限制
        // 时间复杂度: O(a * b * c * d)
        // 空间复杂度: O(1)

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }

    public int fourSumCountTwo(int[] A, int[] B, int[] C, int[] D) {
        // 方案2：哈希 两两分组，将值和出现的次数放入哈希表中
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n^2)

        int res = 0;

        int capacity = (int) (A.length * B.length / 0.75);
        Map<Integer, Integer> map1 = new HashMap<>(capacity);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map1.merge(sum, 1, (a, b) -> a + b);
            }
        }

        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int reverse = -(C[k] + D[l]);
                if (map1.containsKey(reverse)) {
                    res += map1.get(reverse);
                }
            }
        }

        return res;
    }

    public int fourSumCountThree(int[] A, int[] B, int[] C, int[] D) {
        // 方案3：排序 + 双指针

        int res = 0;

        Arrays.sort(C);
        Arrays.sort(D);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0, l = D.length - 1;
                while (k < C.length && l >= 0) {
                    int sum = A[i] + B[j] + C[k] + D[l];
                    if (sum == 0) {
                        int m = 1, n = 1;
                        k++;
                        while (k < C.length && C[k] == C[k - 1]) {
                            m++;
                            k++;
                        }
                        l--;
                        while (l >= 0 && D[l] == D[l + 1]) {
                            n++;
                            l--;
                        }
                        res += m * n;
                    } else if (sum > 0) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }

        return res;
    }
}
