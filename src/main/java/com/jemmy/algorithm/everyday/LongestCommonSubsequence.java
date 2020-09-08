package com.jemmy.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/24
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        // Clarification: 最长公共子串
        // 方案1: 暴力递归，自顶向下 [超出时间限制]
        int m = text1.length(), n = text2.length();

        return recursive(text1, text2, m - 1, n - 1);
    }

    private int recursive(String text1, String text2, int i, int j) {
        // terminator
        if (i == -1 || j == -1) {
            return 0;
        }

        // process current
        // drill down
        if (text1.charAt(i) == text2.charAt(j)) {
            // 聚合: 公共子串长度 + 1
            return recursive(text1, text2, i - 1, j - 1) + 1;
        } else {
            // 聚合: 两种情况下，公共子串较大值
            return Math.max(recursive(text1, text2, i - 1, j), recursive(text1, text2, i, j - 1));
        }

        // reverse current
    }

    private Map<String, Integer> cache = new HashMap<>();

    public int longestCommonSubsequenceTwo(String text1, String text2) {
        // 方案2：递归，自顶向下 + 备忘录

        int m = text1.length(), n = text2.length();

        return recursive2(text1, text2, m - 1, n - 1);
    }

    private int recursive2(String text1, String text2, int i, int j) {
        // terminator
        if (i == -1 || j == -1) {
            return 0;
        }

        String key = i + "_" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int value;

        // process current
        // drill down
        if (text1.charAt(i) == text2.charAt(j)) {
            // 聚合: 公共子串长度 + 1
            value = recursive2(text1, text2, i - 1, j - 1) + 1;
        } else {
            // 聚合: 两种情况下，公共子串较大值
            value = Math.max(recursive2(text1, text2, i - 1, j), recursive2(text1, text2, i, j - 1));
        }

        cache.put(key, value);

        return value;
    }

    public int longestCommonSubsequenceThree(String text1, String text2) {
        // 动态规划 自底向上，数组 + 循环

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 为什么下标从1开始，因为要利用dp下标为0的值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i和j比字符串的下标大1，所以要减1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
