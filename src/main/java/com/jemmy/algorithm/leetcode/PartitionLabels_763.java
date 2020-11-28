package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/27
 */
public class PartitionLabels_763 {

    public List<Integer> partitionLabels(String S) {
        // Clarification: 划分字母区间，同一个字母不能出现在两个区间上，求最多的区间
        // 方案1：贪心算法 + 双指针
        // 先遍历字符串，得出每个字母最后一次出现的位置
        // 然后从起始位置开始，只要区间所有字母的最后位置小于等于i，i即为区间结束

        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int j = 0; j < len; j++) {
            end = Math.max(end, last[S.charAt(j) - 'a']);
            if (j == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
