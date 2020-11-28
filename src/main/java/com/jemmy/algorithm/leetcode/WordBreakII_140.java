package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 140. 单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/2
 */
//public class WordBreakII_140 {
//
//    Map<Integer, String> cache = new HashMap<>();
//    private List<String> res = new ArrayList<>();
//
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        // Clarification: 字符串完全由字典表中的单词组成，用空格分割，求所有可能的组合
//        // 方案1：DFS 针对每个位置，遍历后续的所有分割点，判断是否在字典表中，是则将前缀
//        // 放到返回的字符串中，并递归处理后面
//        // 递归参数：起始位置、字符串、生成的字符串、字典集合
//
//        Set<String> wordSet = new HashSet<>(wordDict);
//        StringBuilder builder = new StringBuilder();
//        dfs(0, s, builder, wordSet);
//
//        return res;
//    }
//
//    private void dfs(int start, String s, StringBuilder builder, Set<String> wordSet) {
//        // terminator
//        if (start == s.length()) {
//            res.add(builder.substring(0, builder.length() - 1));
//            return;
//        }
//
//        if (cache.get(start) != null) {
//            return cache.get(start);
//        }
//
//        // process current logic
//        for (int i = start + 1; i <= s.length(); i++) {
//            // 前缀
//            String prefix = s.substring(start, i);
//
//            if (wordSet.contains(prefix)) {
//                if (builder.length() > 0) {
//                    builder.append(' ');
//                }
//                builder.append(prefix);
//
//                // drill down
//                dfs(i, s, builder, wordSet);
//
//                // reverse current states
//                builder.delete(builder.length() - prefix.length(), builder.length());
//            }
//        }
//    }
//
//}
