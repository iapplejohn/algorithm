package com.jemmy.algorithm.leetcode.top;

/**
 * 172. 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
 *
 * @author zhujiang.cheng
 * @since 2020/9/25
 */
public class FactorialTrailingZeroes_172 {

    public int trailingZeroes(int n) {
        // Clarification: 阶乘尾数中零的数量，先求阶乘，然后获取数量
        // 方案1：数学归纳法 1个0，由 2 * 5 产生，由于 2 出现的个数远远多于 5，只要找到一个5，一定能找到一个 2 与之配对，所以找有多少个 5

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public int trailingZeroesPlus(int n) {
        // 方案1'：数学归纳法 直接从 n 开始除 5 处理：每隔5个数，出现一个5，每隔25个数，出现2个5

        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
