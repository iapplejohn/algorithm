package com.jemmy.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author zhujiang.cheng
 * @since 2020/11/22
 */
public class ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        // Clarification: 判断两个字符串是否字母异位词：长度相同，包含的小写字母种类和个数相同
        // 方案1：排序，然后比较是否相同
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(N);

        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);

        return Arrays.equals(chs1, chs2);
    }

    public boolean isAnagramTwo(String s, String t) {
        // 方案2：计数法，使用哈希表存储
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        // 统计 s 中字符出现的个数
        Map<Character, Integer> countMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            countMap.merge(ch, 1, (a, b) -> a + b);
        }

        // 遍历 t 中的字符，是否出现在 countMap 中：存在就 个数减一，等于 0 删除该键值对；不存在就返回 false
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);

            Integer count = countMap.get(c);
            if (count == null) {
                return false;
            } else {
                if (count == 1) {
                    countMap.remove(c);
                } else {
                    countMap.put(c, --count);
                }
            }
        }

        return countMap.isEmpty();
    }

    public boolean isAnagramThree(String s, String t) {
        // 方案3：计数法，使用数组存储，26个小写字母，相对下标

        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];

        // 统计 s 中字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        // 遍历 t 中的字母，数组对应位置的数字减一，如果小于 0，返回false
        for (int j = 0; j < t.length(); j++) {
            int idx = t.charAt(j) - 'a';
            // 字符串长度相同，如果不是有效的字母异位词，必定有某些字母个数少一些
            if (array[idx] == 0) {
                return false;
            }
            array[idx]--;
        }

        // 不需要再判断数组中是否有元素值大于0，都是等于0
        return true;
    }
}
