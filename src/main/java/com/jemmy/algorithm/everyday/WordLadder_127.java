package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 127. 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/8
 */
public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Clarification: 单词接龙，每次变换一个字符，需要在字典中，求最短变换序列
        // 方案1: 广度优先

        // 所有单词的长度都相同
        int len = beginWord.length();

        // 根据单词表，建立他们之间的关联，键为单词（其中一位为*号)，值为匹配的单词列表
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String wordPattern = word.substring(0, i) + '*' + word.substring(i + 1);
                List<String> matchWords = map.computeIfAbsent(wordPattern, k -> new ArrayList<>());
                matchWords.add(word);
            }
        }

        // BFS 使用队列辅助
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        // 访问过的节点，需要存起来，防止重复使用
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, Boolean.TRUE);

        // 循环
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.k;
            int level = node.v;

            for (int i = 0; i < len; i++) {
                // 单词的每个位置加*
                String wordPattern = word.substring(0, i) + '*' + word.substring(i + 1);

                // 找到匹配的单词列表
                List<String> matches = map.get(wordPattern);
                if (matches != null) {
                    for (String matchWord : matches) {
                        // 匹配的单词为结束单词
                        if (matchWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (!visited.containsKey(matchWord)) {
                            visited.put(matchWord, true);
                            queue.offer(new Pair<>(matchWord, level + 1));
                        }
                    }
                }

            }
        }

        return 0;
    }

    public int ladderLengthTwo(String beginWord, String endWord, List<String> wordList) {
        // 方案2: 双向广度优先
        return 0;
    }
}
