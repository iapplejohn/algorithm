package com.jemmy.algorithm.leetcode.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/22
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        // Clarification: 最后一个字符的长度
        // 方案1: 正则表达式

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(\\s+)?(\\w+)(\\s+)?$");
        java.util.regex.Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String lastWord = matcher.group(2);
            if (lastWord != null) {
                return lastWord.length();
            }
        }

        return 0;
    }

    public int lengthOfLastWordTwo(String s) {
        // 方案2: 从后往前找第一个空格

        char[] chars = s.toCharArray();

        // 最后字符的长度
        int lastLen = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            // 统计最后单词后，往前遇到空格
            if (chars[i] == ' ' && lastLen > 0) {
                break;
            } else if (Character.isUpperCase(chars[i]) || Character.isLowerCase(chars[i])) {
                lastLen++;
            }
        }

        return lastLen;
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 instance = new LengthOfLastWord_58();
        int result = instance.lengthOfLastWord("b   a    ");
        System.out.println(result);
    }
}
