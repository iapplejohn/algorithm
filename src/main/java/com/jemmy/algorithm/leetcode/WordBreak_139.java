package com.jemmy.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/1
 */
public class WordBreak_139 {

    private Boolean[] cache;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Clarification: 字符串是否由单词表中的单词构成
        // 方案1：递归
        // 递归参数：字符串，开始位置，单词集合
        // 递归返回：布尔值，是否符合要求
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)

        Set<String> set = new HashSet<>(wordDict);

        cache = new Boolean[s.length()];

        return dfs(s, 0, set);
    }

    private boolean dfs(String s, int start, Set<String> set) {
        // terminator
        if (start == s.length()) {
            return true;
        }
        if (cache[start] != null) {
            return cache[start];
        }

        // process current logic 针对 start 位置
        for (int i = start + 1; i < s.length(); i++) {
            // 前缀
            String prefix = s.substring(start, i);
            // 前缀在单词表中，且从i开始的字符串也符合条件
            if (set.contains(prefix) && dfs(s, i, set)) {
                cache[start] = true;
                return true;
            }
        }

        cache[start] = false;
        return false;
    }

    public boolean wordBreakTwo(String s, List<String> wordDict) {
        // 方案2：BFS 使用队列辅助

        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];

        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            if (visited[start]) {
                continue;
            }

            visited[start] = true;
            for (int i = start + 1; i <= len; i++) {
                // 前缀
                String prefix = s.substring(start, i);
                if (wordSet.contains(prefix)) {
                    // i 还没有越界
                    if (i < len) {
                        queue.offer(i);
                    } else {
                        // 到末尾，找到解了
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean wordBreakThree(String s, List<String> wordDict) {
        // 方案3：动态规划 TODO
        // 状态定义: dp[i]
        return false;
    }
}
