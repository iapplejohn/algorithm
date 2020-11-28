/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: RGBSort.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/6 11:29
 * Description:
 */
package com.jemmy.algorithm.july.array;

import java.util.Arrays;

/**
 * 给定一个字符串里面只有"R" "G" "B" 三个字符，请排序，最终结果的顺序是R在前 G中 B在后。
 * <p>
 * 要求：空间复杂度是O(1)，且只能遍历一次字符串。
 *
 * 二分思想：以G为中心，R往前扔（无序开始位置），B往后扔（无序结束位置）
 *
 * 往前扔：无序位置往后挪一位；往后扔，无序结束位置往后挪一位
 *
 * 三个位置：无序开始、当前位置、无序结束
 *
 * 循环开始：无序开始位置 = 当前位置 = 0
 *
 * 循环结束：当前位置 = 无序结束位置
 *
 * @author Cheng Zhujiang
 * @date 2017/7/6
 */
public class RGBSort {

    private static void sort(char[] arr) {
        int begin = 0, current = 0, end = arr.length -1;

        while (current <= end) {
            if (arr[current] == 'R') {
                swap(arr, current, begin);
                begin++;
                current++;
            } else if (arr[current] == 'G') {
                current++;
            } else {
                swap(arr, current, end);
                end--;
            }
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        char[] arr = {'B', 'G', 'R', 'R', 'G', 'G', 'B', 'R', 'G', 'G', 'B', 'R'};
        sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
