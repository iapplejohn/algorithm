/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: DutchNationalFlag.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/6 10:47
 * Description: 
 */
package com.jemmy.algorithm.july.array;

import java.util.Arrays;

/**
 * 荷兰国旗
 * <p>
 * 题目描述
 * <p>
 * 拿破仑席卷欧洲大陆之后，代表自由，平等，博爱的竖色三色旗也风靡一时。荷兰国旗就是一面三色旗（只不过是横向的），自上而下为红白蓝三色。
 * <p>
 * 该问题本身是关于三色球排序和分类的，由荷兰科学家Dijkstra提出。由于问题中的三色小球有序排列后正好分为三类，Dijkstra就想象成他母国的国旗，于是问题也就被命名为荷兰旗问题（Dutch National Flag Problem）。
 * <p>
 * 下面是问题的正规描述： 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。
 *
 * @author Cheng Zhujiang
 * @date 2017/7/6
 */
public class DutchNationalFlag {

    static void sort(int[] arr) {
        int begin = 0, current = 1, end = arr.length - 1;

        while (current <= end) {
            if (arr[current] == 0) {
                swap(arr, begin, current);
                begin++;
                current++;
            } else if (arr[current] == 1) {
                current++;
            } else {
                swap(arr, end, current);
                end--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 0, 2, 0, 0, 1, 2 };
        sort(arr);
    }
}
