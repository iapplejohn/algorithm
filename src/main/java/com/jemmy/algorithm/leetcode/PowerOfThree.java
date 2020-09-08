package com.jemmy.algorithm.leetcode;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 *
 * @author zhujiang.cheng
 * @since 2020/6/6
 */
public class PowerOfThree {

    /**
     * 方案1：循环是否被3整除，直到余数为1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 方案2：将数值转换为以基数3为底的数，然后判断是否以1开头，后面都是0
     *
     * 时间复杂度: O(log3n)
     * 空间复杂度: O(log3n)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree_2(int n) {
        if (n <= 0) {
            return false;
        }

        String val = Integer.toString(n, 3);
        return val.matches("^10*$");
    }

    /**
     * 方案3:
     * 若 n 是 3 的幂则 i 是整数。在 Java 中，我们通过取小数部分（利用 % 1）来检查数字是否是整数，并检查它是否是 0。
     *
     *
     * 时间复杂度: Unknown
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree_3(int n) {
        if (n <= 0) {
            return false;
        }

        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.log10(32) / Math.log10(3));
    }

    /**
     * 方案4：int最大值为2147483647，而3的幂次方最大为1162261467，
     * 1162261467对所有符合条件的n取余都为0
     *
     * 时间复杂度：O(1) 我们只做了一次操作
     * 空间复杂度: O(1) 没有使用额外的空间
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree_4(int n) {
        return n > 0 && (1162261467 % n == 0);
    }

}
