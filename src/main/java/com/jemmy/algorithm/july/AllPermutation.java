/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: AllPermutation.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/3 11:21
 * Description: 
 */
package com.jemmy.algorithm.july;

/**
 * AllPermutation
 *
 * @author Cheng Zhujiang
 * @date 2017/7/3
 */
public class AllPermutation {

    public static void permutate(char[] chs, int from, int to) {
        if (from == to) {
            System.out.println(new String(chs));
        } else {
            for (int j = from; j <= to; j++) {
                swap(chs, from, j);
                permutate(chs, from + 1, to);
                swap(chs, from, j);
            }
        }
    }

    private static void swap(char[] chs, int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }

    public static void main(String[] args) {
        char[] chs = "abcd".toCharArray();
        permutate(chs, 0, 3);
    }

}
