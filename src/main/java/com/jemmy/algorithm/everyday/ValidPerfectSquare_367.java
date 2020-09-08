package com.jemmy.algorithm.everyday;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/11
 */
public class ValidPerfectSquare_367 {

    public boolean isPerfectSquare(int num) {
        // Clarification: 如果该数为正整数的平方，返回true
        // 方案1: 二分法
        // 时间复杂度: O(logn)
        // 空间复杂度: O(1)

        if (num == 1) {
            return true;
        }

        // 二分查找
        // 这里要定义为long型，否则相乘可能会溢出，导致结果错误
        // left 初始值可以从1或2开始，right 初始值可以为 num 或 num / 2（右移一位也可）
        long left = 1, right = num >> 1;
        while (left <= right) {
            // (right - left) >> 1 要用括号括起来，否则优先级不对
            long mid = left + ((right - left) >> 1);
            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquareTwo(int num) {
        // 方案2: 牛顿迭代法 TODO
        return false;
    }
}
