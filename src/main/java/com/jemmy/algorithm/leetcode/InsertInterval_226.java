package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/4
 */
public class InsertInterval_226 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Clarification: 往无重叠、按区间起始端点排序的区间列表，插入一个新的区间，确保区间仍然有序且不重叠（可以合并区间）
        // 方案1：找到插入点 或 重叠区间

        List<int[]> res = new ArrayList<>();

        int i = 0, len = intervals.length;

        // 左侧不重叠的区间（新区间左侧比当前区间右侧大）：加到结果中
        while (i < len && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        // 重叠区间（新区间右侧比当前区间左侧大）
        int[] temp = new int[] {newInterval[0], newInterval[1]};
        while (i < len && newInterval[1] >= intervals[i][0]) {
            temp[0] = Math.min(temp[0], intervals[i][0]);
            temp[1] = Math.max(temp[1], intervals[i][1]);
            i++;
        }
        res.add(temp);

        // 右侧不重叠区间
        while (i < len) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][0]);
    }
}
