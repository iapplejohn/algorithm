/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: CharToInteger.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/9 22:19
 * Description: 
 */
package com.jemmy.algorithm.july.character;

/**
 * CharToInteger
 *
 * @author Cheng Zhujiang
 * @date 2017/7/9
 */
public class CharToInteger {

    static int charToInt(String str) {
        if (str == null) { // 判空
            throw new IllegalArgumentException("Input is null");
        }

        int sign = 1; // 正负符号
        if (str.charAt(0) == '-') {
            sign = -1;
        }

        int val = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            int dif = ch - '0';
            if (dif < 0 || dif > 9) { // 非法字符
                throw new IllegalArgumentException("Not a valid number");
            }
            val += dif * Math.pow(10, len - i - 1);
        }

        return val * sign;
    }

    public static void main(String[] args) {
        String str = "16-";
        int result = charToInt(str);
        System.out.println(result);
    }

}
