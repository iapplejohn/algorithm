package com.jemmy.algorithm.leetcode.back;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/11
 */
public class CombinationSumIII_216 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // Clarification: 使用 1-9 中的 k 个不重复的数，和为 n，说明 k <= 9
        // 方案1: 回溯
        // 递归参数: 当前数字, 最高数字, k, n, 是否使用数组

        if (k > n) {
            return res;
        }

        boolean[] used = new boolean[9];

        recursive(1, 9, k, n, used);

        return res;
    }

    private void recursive(int begin, int end, int k, int rest, boolean[] used) {
        // terminator
        if (rest < 0 || list.size() > k) {
            return;
        }

        // process current logic
        for (int i = begin; i <= end; i++) {
            if (used[i - 1]) {
                continue;
            }

            if (rest >= i) {
                used[i - 1] = true;
                list.add(i);

                if (rest - i == 0 && list.size() == k) {
                    res.add(new ArrayList<>(list));
                } else {
                    // drill down
                    recursive(i + 1, end, k, rest - i, used);
                }

                // reverse current states
                used[i - 1] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    // 方案2: 动态规划
}
