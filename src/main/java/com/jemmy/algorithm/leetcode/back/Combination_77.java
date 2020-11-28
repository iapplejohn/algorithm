package com.jemmy.algorithm.leetcode.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/8
 */
public class Combination_77 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // Clarification: 1...n 个数中，拿出k个数，组成数组，多少种可能
        // 方案1: 回溯
        // 递归参数: n, 当前数，k, 当前组合

        if (n == 0 || k == 0 || n < k) {
            return res;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        recursive(n, 1, k, stack);

        return res;
    }

    private void recursive(int n, int start, int k, LinkedList<Integer> stack) {
        // terminator
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i <= n; i++) {
            // process current logic
            stack.push(i);

            // drill down
            recursive(n, start + 1, k, stack);

            // reverse current states
            stack.pop();
        }
    }
}
