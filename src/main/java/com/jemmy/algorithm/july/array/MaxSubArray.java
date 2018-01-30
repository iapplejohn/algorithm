/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: MaxSubArray.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/4 9:21
 * Description: 
 */
package com.jemmy.algorithm.july.array;

/**
 * 最大连续子数组和
 * 题目描述
 * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
 *
 * @author Cheng Zhujiang
 * @date 2017/7/4
 */
public class MaxSubArray {

    // 最简单最暴力的方式，使用3个for循环，时间复杂度为O(n ^ 3)
    static int findByLoopAndLoop(int[] a) {
        int maxSum = a[0];
        int currSum = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k < j; k++) {
                    currSum += a[k];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;
                }

                currSum = 0;
            }
        }

        return maxSum;
    }

    // 更好的方式，时间复杂度为O(n)
    static int findByLoop(int[] a) {
        int maxSum = a[0];
        int currSum = a[0];
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int temp = currSum + a[i];
            if (temp > a[i]) {
                currSum += a[i];
            } else {
                currSum = a[i]; // 丢掉负值的数据
            }

            // 可能目前就是最大值，加上后面的值反而变小了，所以需要每次都要去比较，记录最大的连续子数组之和
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = { 1, -2, 3, 10, -4, 7, 2, -5 };
//        int max = findByLoopAndLoop(a);
        int max = findByLoop(a);
        System.out.println(max);
    }

}
