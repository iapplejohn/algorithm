/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: GreedyFirst.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/6 19:28
 * Description: 
 */
package com.jemmy.algorithm.greedy;

import java.util.Arrays;

/**
 * 贪心算法的基本思路：
 * <p>
 * 从问题的某一步初始化解出逐步逼近给定的目标，以尽可能快地求得更好的解。
 * 当达到算法中的某一步不能再继续前进时，就停止算法，给出近似解。
 * <p>
 * 下面就一个例子来说明贪心的实现过程：就以一个换零钱的例子吧，输入一个数字的面额，求出用100,50...等等面额怎么才能换成像对应的钱
 *
 * @author Cheng Zhujiang
 * @date 2017/7/6
 */
public class GreedyFirst {

    static int[] value = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10};
    static int[] number = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static void lookForViaGreed(int a) {
        int i;

        for (i = 0; i < 10; i++) {
            if (a > value[i]) { // > or >=
                break;
            }
        }

        while (a > 0 && i < 10) {
            if (a >= value[i]) {
                a = a - value[i];
                number[i]++;
            } else if (a < 10 && i >= 5) {
                number[9]++;
                break;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(number));
    }

    public static void main(String[] args) {
        int a = 105;
        lookForViaGreed(a);
    }

}
