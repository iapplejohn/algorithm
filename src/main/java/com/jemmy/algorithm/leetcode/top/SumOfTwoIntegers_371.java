package com.jemmy.algorithm.leetcode.top;

/**
 * 371. 两整数之和
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/4
 */
public class SumOfTwoIntegers_371 {

    public int getSum(int a, int b) {
        // Clarification: 两数之和，不使用 + -
        // 方案1: 位运算，递归
        // 异或实现加操作，与+左移1位实现进位操作

        if (b == 0) {
            return a;
        }

        // 加操作
        int sum = a ^ b;

        // 进位操作
        int carry = (a & b) << 1;

        return getSum(sum, carry);
    }

    // 方案2: 位运算，迭代
}
