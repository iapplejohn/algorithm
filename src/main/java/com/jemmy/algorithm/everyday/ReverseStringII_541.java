package com.jemmy.algorithm.everyday;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/19
 */
public class ReverseStringII_541 {

    public String reverseStr(String s, int k) {
        // Clarification: 反转字符串
        // 方案1: 循环 + 尾处理
        // 开始反转k个字符串，间隔k个，再反转k个，间隔k个
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int len = s.length();
        int value = len / k;
        char[] chs = s.toCharArray();

        // 不止k个字符串：按照奇偶性，先反转k个，间隔k个，再反转k个，间隔k个
        for (int i = 0; i < value; i++) {
            if ((i & 0x1) == 0) {
                int begin = i * k;
                int end = begin + k - 1;
                reverse(chs, begin, end);
            }
        }

        // value （偶数）个k，后面全部反转：整除时，value * k < len - 1，退出循环
        if ((value & 0x1) == 0) {
            reverse(chs, value * k, len - 1);
        }

        return new String(chs);
    }

    private void reverse(char[] chs, int begin, int end) {
        while (begin < end) {
            char temp = chs[begin];
            chs[begin] = chs[end];
            chs[end] = temp;
            begin++;
            end--;
        }
    }

    public String reverseStrPlus(String s, int k) {
        // 方案1: 循环 + 尾处理
        // 开始反转k个字符串，间隔k个，再反转k个，间隔k个
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int len = s.length();
        int value = len / k;
        char[] chs = s.toCharArray();

        // 不止k个字符串：按照奇偶性，先反转k个，间隔k个，再反转k个，间隔k个
        for (int i = 0; i < value; i++) {
            // 偶数时，k个字符（尾部时可能少于）反转
            if ((i & 0x1) == 0) {
                int begin = i * k;
                // 正常为 begin + k - 1；尾部时：为 len - 1
                int end = Math.min(begin + k - 1, len - 1);
                reverse(chs, begin, end);
            }
        }

        return new String(chs);
    }

    public static void main(String[] args) {
        ReverseStringII_541 instance = new ReverseStringII_541();
        instance.reverseStr("abcd", 2);
    }
}
