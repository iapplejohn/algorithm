/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: MaxContinousMultiple.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/7 9:43
 * Description: 
 */
package com.jemmy.algorithm.july.dynamicplan;

/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/05.01.md
 * 给一个浮点数序列，取最大乘积连续子串的值，例如 -2.5，4，0，3，0.5，8，-1，
 * 则取出的最大乘积连续子串为3，0.5，8。
 * 也就是说，上述数组中，3 0.5 8这3个数的乘积30.58=12是最大的，而且是连续的。
 *
 * @author Cheng Zhujiang
 * @date 2017/7/7
 */
public class MaxContinousMultiple {

    /**
     * 或许，读者初看此题，可能立马会想到用最简单粗暴的方式：两个for循环直接轮询。
     * 时间复杂度O(n ^ 2)
     *
     * @param arr
     * @return
     */
    static double fetchViaLoopAndLoop(double[] arr) {
        double max = arr[0];
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            double temp = 1; // arr[i]
            for (int j = i; j < n; j++) { // i+1
                temp *= arr[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    /**
     * 动态规划法
     * 时间复杂度O(n)
     *
     * @param arr
     * @return
     */
    static double fetchViaDynamic(double[] arr) {
        double maxEnd = arr[0], minEnd = arr[0], maxResult = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double end1 = maxEnd * arr[i];
            double end2 = minEnd * arr[i];
            maxEnd = Math.max(Math.max(end1, end2), arr[i]);
            minEnd = Math.min(Math.min(end1, end2), arr[i]);
            if (maxEnd > maxResult) {
                maxResult = maxEnd;
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
        double max = fetchViaLoopAndLoop(arr);
        System.out.println(max);
        double max2 = fetchViaDynamic(arr);
        System.out.println(max2);

        double maxN_1ViaLoop = fetchMaxN_1ResultViaLoopAndLoop(arr);
        System.out.println(maxN_1ViaLoop);

        double maxN_1 = fetchMaxN_1Result(arr);
        System.out.println(maxN_1);
    }

    // 方法复杂度为O(n ^ 2)
    static double fetchMaxN_1ResultViaLoopAndLoop(double[] arr) {
        double maxResult = 0;

        for (int i = 0; i < arr.length; i++) {
            double temp = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }

                temp *= arr[j];
            }

            if (temp > maxResult) {
                maxResult = temp;
            }
        }

        return maxResult;
    }

    /**
     * 1、给定一个长度为N的整数数组，只允许用乘法，不能用除法，
     * 计算任意（N-1）个数的组合中乘积最大的一组，并写出算法的时间复杂度。
     * 下面思路不对
     *
     * @deprecated
     * @param arr
     * @return
     */
    static double fetchMaxN_1Result(double[] arr) {
        double max = arr[0], min = arr[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        double result1 = 1, result2 = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i != maxIndex) {
                result1 *= arr[i];
            }
            if (i != minIndex) {
                result2 *= arr[i];
            }
        }

        return Math.max(result1, result2);
    }
}
