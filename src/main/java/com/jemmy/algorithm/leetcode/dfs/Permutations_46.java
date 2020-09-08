package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/27
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        // Clarification: 数组没有重复数字，求全排列
        // 方案1: 递归+回溯
        // 递归参数: 数组, 当前深度, 最大深度, 当前路径, 数组[是否使用], 结果集

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>(len * 2);
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        int depth = 0;
        List<Integer> path = new ArrayList<>(len);

        dfs(nums, depth, len, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth, int len, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        // terminator
        if (depth == len) {
            // 注意: 需要对 path 做拷贝，否则结果为空
            res.add(new ArrayList<>(path));
            return;
        }

        // process current logic
        for (int i = 0; i < len; i++) {
            // 已使用
            if (used[i]) {
                continue;
            }

            // 当前排列追加该字符，并设置为已使用
            path.add(nums[i]);
            used[i] = true;

            // drill down
            dfs(nums, depth + 1, len, path, used, res);

            // reverse current status
            // 当前排列去除最后一位，并设置为未使用
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // 方案2: 循环
}
