package com.jemmy.algorithm.leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/10
 */
public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        // Clarification:  输出杨辉三角的前 numRows 行
        // 方案1: 模拟法 每行的元素个数 = 行数，起始和结束元素的值都为1，其他元素值=上一行相邻两个元素值相加

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> list = new ArrayList<>(1);
                list.add(1);
                res.add(list);
            } else if (i == 2) {
                List<Integer> list = new ArrayList<>(2);
                list.add(1);
                list.add(1);
                res.add(list);
            } else {
                List<Integer> list = new ArrayList<>(i);
                list.add(1);
                List<Integer> last = res.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    int val = last.get(j - 1) + last.get(j);
                    list.add(val);
                }
                list.add(1);
                res.add(list);
            }
        }

        return res;
    }

    // 方案2: 错位相加
}
