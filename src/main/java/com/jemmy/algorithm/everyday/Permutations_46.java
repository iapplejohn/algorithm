package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
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
 * @since 2020/7/20
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        // Clarification: 全排列，无重复数字
        // 方案1: 递归（深度优先）+回溯

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        int depth = 0;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, depth, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used,
        List<Integer> path, List<List<Integer>> res) {

        // terminator
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // process current
        // drill down
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, used, path, res);

                // reverse current
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations_46 instance = new Permutations_46();
        List<List<Integer>> result = instance.permute(new int[] {1, 2, 3});
        System.out.println(result);
    }
}
