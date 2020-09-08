package com.jemmy.algorithm.search;

import java.util.Scanner;

/**
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 输入两个字符串
 * 返回重复出现的字符
 *
 * 示例1
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * jklmnop
 *
 * @author zhujiang.cheng
 * @since 2020/2/22
 */
public class SameSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String max = s1.length() > s2.length() ? s1 : s2;
            String min = s1.length() > s2.length() ? s2 : s1;
            String s = "";
            int l = 0;
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {
                    if (max.contains(min.substring(i, j)) && j - i > l) {
                        l = j - i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s);
        }

    }

}
