package com.jemmy.algorithm.leetcode;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 *
 * @author zhujiang.cheng
 * @since 2020/6/6
 */
public class PowerOfTwo {

    /**
     * 方案1: 每次看是否被2整除，直到余数为1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    /**
     * 方案2:
     * 2的幂次方，只有最高位上是1，后面为0，减一和其&的值为0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo_2(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
