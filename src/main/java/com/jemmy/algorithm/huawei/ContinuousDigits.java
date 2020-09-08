package com.jemmy.algorithm.huawei;

import java.util.Scanner;

/**
 * 请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串
 *
 * 样例输入
 *
 * abcd12345ed125ss123058789
 *
 * abcd12345ss54761
 *
 * 样例输出
 *
 * 输出123058789，函数返回值9
 *
 * 输出54761，函数返回值5
 *
 * @author zhujiang.cheng
 * @since 2020/2/23
 */
public class ContinuousDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            System.out.println(continueMax(str));
        }
    }

    private static int continueMax(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int maxStart = 0;
        int maxEnd = 0;
        int length;
        int j;
        int value = 0;

        for (int i = 0; i < str.length(); i++) {
            j = i;
            length = 0;

            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                i++;
                length++;
            }

            if (length > value) {
                value = length;
                maxStart = j;
                maxEnd = i;
            }
        }
        System.out.println(str.substring(maxStart, maxEnd));

        return value;
    }
}
