package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N 皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/3
 */
public class NQueens_51 {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pies = new HashSet<>();
    private Set<Integer> nas = new HashSet<>();

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // Clarification: n 皇后问题，返回不同的解决方案
        // 方案1: 回溯
        // 一行只有一个皇后(否则会相互攻击)，就是看放在哪一列，放完后，看下一个皇后放在哪一列，最后一行放号后，回溯，看有没其他解法
        // 如何标记攻击范围，利用集合: 列集合、撇集合（row + col)、捺集合(row - col)（回溯时需要清除）
        // 没有行集合，因为每行只放一个皇后
        // 递归参数: 行数，当前行，皇后的列集合

        // 皇后的列集合
        List<Integer> colList = new ArrayList<>();
        dfs(n, 0, colList);

        // 结果输出
        List<List<String>> ans = buildResult(n);

        return ans;
    }

    private void dfs(int n, int row, List<Integer> colList) {
        // terminator
        if (row == n) {
            result.add(new ArrayList<>(colList));
            return;
        }

        // process current logic 遍历每个列
        for (int col = 0; col < n; col++) {
            // 判断是否处于之前皇后的攻击范围
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                continue;
            }

            colList.add(col);

            // 当前皇后的攻击范围加到已有列表
            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);

            // drill down 下一个皇后如何放置
            dfs(n, row + 1, colList);

            // reverse current states 回溯
            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);

            colList.remove(colList.size() - 1);
        }
    }

    private List<List<String>> buildResult(int n) {
        List<List<String>> ans = new ArrayList<>();
        for (List<Integer> list : result) {
            List<String> rowList = new ArrayList<>();
            for (Integer col : list) {
                StringBuilder builder = new StringBuilder(n);
                for (int i = 0; i < col; i++) {
                    builder.append('.');
                }
                builder.append('Q');
                for (int j = col + 1; j < n; j++) {
                    builder.append('.');
                }
                rowList.add(builder.toString());
            }
            ans.add(rowList);
        }
        return ans;
    }
}
