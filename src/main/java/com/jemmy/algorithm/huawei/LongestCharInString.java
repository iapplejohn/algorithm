package com.jemmy.algorithm.huawei;

import java.io.IOException;
import java.util.Scanner;

/**
 * 输入多组字符串，输出：字符串中字符重复最多的子串，不区分大小写
 *
 * 示例：
 * 输入：
 * aAbbBBcccCCC
 * ddddDDDDeeEEeeEEeeEE
 *
 * 输出：
 * eeEEeeEEeeEE
 *
 * @author zhujiang.cheng
 * @since 2020/2/23
 */
public class LongestCharInString {

    public static void main(String[] args) throws IOException {
        int maxLen = 0;
        String result = "";

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String max = continueMax(str);
            if (max.length() > maxLen) {
                maxLen = max.length();
                result = max;
            }
        }
        System.out.println(result);
    }

    private static String continueMax(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        if (str.length() == 1) {
            return str;
        }

        int maxStart = 0;
        int maxEnd = 0;
        int value = 0;
        int length;
        int j;

        for (int i = 0; i < str.length(); i++) {
            j = i;
            length = 0;
            char ch = str.charAt(j);

//            while ((i + 1 < str.length()) && String.valueOf(str.charAt(i + 1)).equalsIgnoreCase(String.valueOf(ch))) {
            while ((i + 1 < str.length()) &&
                (Character.isUpperCase(str.charAt(i + 1)) && Character.isUpperCase(ch) && str.charAt(i + 1) == ch
                || Character.isUpperCase(str.charAt(i + 1)) && Character.isLowerCase(ch) && (str.charAt(i + 1) + 32 == ch)
                || Character.isLowerCase(str.charAt(i + 1)) && Character.isUpperCase(ch) && (str.charAt(i + 1) == ch + 32)
                || Character.isLowerCase(str.charAt(i + 1)) && Character.isLowerCase(ch) && str.charAt(i + 1) == ch)) {
                i++;
                length++;
            }

            if (length > value) {
                value = length;
                maxStart = j;
                maxEnd = i;
            }
        }

        if (maxEnd > 0) {
            return str.substring(maxStart, maxEnd + 1);
        } else {
            return "";
        }
    }


}
