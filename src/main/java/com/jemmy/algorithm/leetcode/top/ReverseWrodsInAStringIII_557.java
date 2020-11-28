package com.jemmy.algorithm.leetcode.top;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/25
 */
public class ReverseWrodsInAStringIII_557 {

    public String reverseWords(String s) {
        // Clarification: 反转字符串中的单词，空格和单词的顺序保存不变
        // 方案1: 遍历字符，判断单词，双指针前后替换

        char[] chars = s.toCharArray();
        boolean hasWord = false;
        int begin = -1;
        int end;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                end = i - 1;
                swap(chars, begin, end);
                hasWord = false;
            } else {
                if (!hasWord) {
                    hasWord = true;
                    begin = i;
                }
            }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = temp;
        }
    }

}
