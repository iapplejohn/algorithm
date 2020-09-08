package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/5
 */
public class PermutationSequence_60 {

    public String getPermutation(int n, int k) {
        // 返回第 k 个排列
        // 方案1：获取所有排列，直到第 k 个时，返回
        // 递归参数: depth, n, k, path, used, res

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];

        dfs(0, n, k, path, used, res);

        List<Integer> seq = res.get(0);
        StringBuilder builder = new StringBuilder(seq.size());
        for (Integer num : seq) {
            builder.append(num);
        }

        return builder.toString();
    }

    private void dfs(int depth, int n, int k, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        // terminator
        if (depth == n) {
            if (depth == k) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            // process current logic
            used[i] = true;
            path.add(i);

            // drill down
            dfs(depth + 1, n, k, path, used, res);

            // reverse current states
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
        // 方案2：直接判断所有
