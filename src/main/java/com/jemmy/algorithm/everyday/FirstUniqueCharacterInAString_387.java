package com.jemmy.algorithm.everyday;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/17
 */
public class FirstUniqueCharacterInAString_387 {

    public int firstUniqChar(String s) {
        // Clarification: 找到第一个不重复的字符，返回其索引，不存在则返回-1，输入只包含小写字母
        // 方案1: 使用 LinkedHashMap（有序）统计，然后遍历map
        // 时间复杂度: O(n^2) n为字符个数
        // 空间复杂度: O(n)

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character ch : s.toCharArray()) {
            map.merge(ch, 1, (a, b) -> a + b);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            Integer count = entry.getValue();
            if (count == 1) {
                return s.indexOf(ch);
            }
        }

        return -1;
    }

    public int firstUniqCharPlus(String s) {
        // 方案1+: 使用 HashMap 统计，然后遍历字符串中的字符
        // 时间复杂度: O(n) n为字符个数
        // 空间复杂度: O(n)

        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>(len);
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, (a, b) -> a + b);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqCharTwo(String s) {
        // 方案2：使用 数组 统计个数

        // 统计字符出现个数
        int[] array = new int[26];
        for (Character ch : s.toCharArray()) {
            array[ch - 'a']++;
        }

        // 遍历字符，判断是否只出现一次
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
