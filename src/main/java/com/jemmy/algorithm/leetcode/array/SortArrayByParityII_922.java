package com.jemmy.algorithm.leetcode.array;

/**
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/12
 */
public class SortArrayByParityII_922 {

    public int[] sortArrayByParityII(int[] A) {
        // Clarification: 非负整数数组，一半奇数，一半偶数，奇数位置放奇数，偶数位置放偶数
        // 方案1：分别获取奇数和偶数，放到列表中，然后放回去
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int len = A.length;

        int[] odds = new int[len / 2];
        int[] evens = new int[len / 2];
        int i = 0, j = 0;

        for (int num : A) {
            if ((num & 1) == 0) {
                odds[i++] = num;
            } else {
                evens[j++] = num;
            }
        }

        for (int k = len - 1; k >= 1; k -= 2) {
            A[k] = odds[--i];
        }

        for (int l = len - 2; l >= 0; l -= 2) {
            A[l] = evens[--j];
        }

        return A;
    }

    public int[] sortArrayByParityIITwo(int[] A) {
        // 方案2：遍历，构建结果数组，遍历 A，为奇数放到结果数组奇数位，为偶数放到结果数组偶数位

        int[] res = new int[A.length];
        int i = 0, j = 1;

        for (int num : A) {
            if ((num & 1) == 0) {
                res[i] = num;
                i += 2;
            } else {
                res[j] = num;
                j += 2;
            }
        }

        return res;
    }

    public int[] sortArrayByParityIIThree(int[] A) {
        // 方案3：双指针，针对奇偶位，分别维护 j 和 i，然后遍历偶数位，如果不是偶数，从奇数位找偶数

        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
