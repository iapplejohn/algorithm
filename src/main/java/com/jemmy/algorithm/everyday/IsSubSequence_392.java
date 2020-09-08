package com.jemmy.algorithm.everyday;

/**
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/28
 */
public class IsSubSequence_392 {

    public boolean isSubsequence(String s, String t) {
        // Clarification: 子序列
        // 方案1：递归

        if (s == null || s.length() == 0) {
            return true;
        }

        int m = s.length();
        int n = t.length();

        // 从后往前处理
        return recursive(s, t, m - 1, n - 1);
    }

    public boolean recursive(String s, String t, int i ,int j) {
        // terminator
        if (i < 0 || j < 0) {
            return false;
        }

        // process current logic
        // drill down
        // 字符相同
        if (s.charAt(i) == t.charAt(j)) {
            // 字符串 s 已匹配完成
            if (i == 0) {
                return true;
            } else {
                // i 和 j 指针往前
                return recursive(s, t, i - 1, j - 1);
            }
        } else {
            // i 不动，j 指针往前
            return recursive(s, t, i, j - 1);
        }

        // reverse current
    }

    public boolean isSubsequenceTwo(String s, String t) {
        // 方案2：双指针法 贪心策略

        int m = s.length(), n = t.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            // 字符相同时，i 和 j 都前移，否则只有 j 前移
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        // i 到了 m，说明匹配完成
        return i == m;
    }

    public boolean isSubsequenceThree(String s, String t) {
        // 动态规划 TODO
        return false;
    }
}
