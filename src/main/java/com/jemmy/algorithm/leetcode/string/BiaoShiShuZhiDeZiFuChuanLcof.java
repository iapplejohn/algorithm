package com.jemmy.algorithm.leetcode.string;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author zhujiang.cheng
 * @since 2020/9/2
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {

    /**
     * 整数和小数几种可能：3, 3.5, .5, 5.
     */
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[-+]?(\\d+|\\d+\\.|\\.\\d+|\\d+\\.\\d+)([eE]-?\\d+)?");

    public boolean isNumber(String s) {
        // 是否数值
        // 方案1: 正则表达式

        if (s == null || s.isEmpty()) {
            return false;
        }

        boolean result = pattern.matcher(s.trim()).matches();
        return result;
    }

}
