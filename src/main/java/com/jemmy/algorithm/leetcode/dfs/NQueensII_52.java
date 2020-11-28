package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 52. N皇后 II
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/17
 */
public class NQueensII_52 {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pies = new HashSet<>();
    private Set<Integer> nas = new HashSet<>();
    private int solutions = 0;

    public int totalNQueens(int n) {
        // Clarification: n 皇后的不同方案
        // 方案1：递归+回溯
        // 每行只能放一位皇后（相互之间不会攻击），尝试不同的列，前面的皇后放好后，后面的皇后不在前面的攻击范围内
        // 攻击范围：列、斜杠、反斜杠
        // 递归参数: 行/列数、当前行、皇后位置列表

        dfs(n, 0);
        return solutions;
    }

    private void dfs(int n, int row) {
        // terminator
        if (row == n) {
            solutions++;
            return;
        }

        // 从左到右，尝试每个列
        for (int col = 0; col < n; col++) {
            // process current logic
            // 判断是否在之前皇后的攻击范围内
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);

            // drill down
            dfs(n, row + 1);

            // reverse current states
            nas.remove(row - col);
            pies.remove(row + col);
            cols.remove(col);
        }
    }
}
