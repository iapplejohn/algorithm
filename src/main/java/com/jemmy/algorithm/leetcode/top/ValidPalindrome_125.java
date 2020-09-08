package com.jemmy.algorithm.leetcode.top;

/**
 * 125. 验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 *
 * 输入: "race a car" 输出: false
 *
 * @author zhujiang.cheng
 * @since 2020/9/3
 */
public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {
        // Clarification: 判断是否回文串，空格和标点符号不算
        // 方案1: 筛选 + 判断（使用 reverse，然后判断是否相同)
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }

        String filteredOrigin = builder.toString();
        String filteredReverse = builder.reverse().toString();

        return filteredOrigin.equalsIgnoreCase(filteredReverse);
    }

    public boolean isPalindromePlus(String s) {
        // 方案1': 筛选 + 判断（双指针）
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                // 全部转成小写，方便后续比较
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        // 双指针
        int left = 0, right = builder.length() - 1;
        while (left < right) {
            if (builder.charAt(left) != builder.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindromeTwo(String s) {
        // 方案2: 原字符串上直接判断（双指针）
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = s.charAt(left);
            if (!Character.isLowerCase(leftChar)) {
                leftChar = Character.toLowerCase(leftChar);
            }
            char rightChar = s.charAt(right);
            if (!Character.isLowerCase(rightChar)) {
                rightChar = Character.toLowerCase(rightChar);
            }

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 instance = new ValidPalindrome_125();
        boolean result = instance.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}
