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
public class DutchNationalFlag {

    private static void sort(int[] arr) {
        // begin: 无序开始下标，初始值为数组开始
        // current: 当前指针，初始值为0，为什么不能为1？当第一个元素值为2，后续元素值为1或2的时候，第一个元素的2不会被交换
        // end: 无序结束下标，初始值为数组末尾
        int begin = 0, current = 0, end = arr.length - 1;

        while (current <= end) {
            // 值为0，交换当前指针和无序开始下标的元素，无序开始下标都自增，当前指针自增?因为交换过来的元素只可能是1
            if (arr[current] == 0) {
                swap(arr, begin, current);
                begin++;
                current++;
            } else if (arr[current] == 1) {
                current++;
            } else { // 值为2，交换当前指针和无序结束下标的元素，无序结束下标自减，为什么当前指针不自增，因为交换过来的元素可能不合格
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
        //int[] arr = { 2, 1, 0, 2, 0, 0, 1, 2 };
        int[] arr = { 2, 1, 1, 2 };
        sort(arr);
    }
}
