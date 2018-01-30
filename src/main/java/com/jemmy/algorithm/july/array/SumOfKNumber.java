/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: SumOfKNumber.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/25 9:07
 * Description: 
 */
package com.jemmy.algorithm.july.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入两个整数n和sum，从数列1，2，3.......n 中随意取几个数，使其和等于sum，要求将其中所有的可能组合列出来。
 *
 * @author Cheng Zhujiang
 * @date 2017/7/25
 */
public class SumOfKNumber {

    List<Integer> list = new LinkedList<>();
    int count;

    // 解法1
    // 注意到取n，和不取n个区别即可，考虑是否取第n个数的策略，可以转化为一个只和前n-1个数相关的问题。
    void sumOfKNumber(int sum, int n) {
        if (sum <= 0 || n <= 0) {
            return;
        }

        if (sum == n) {
            for (Integer num: list) {
                System.out.print(num + "  ");
            }
            System.out.print(n);
            System.out.println();
            count++;
        }

        list.add(n);
        sumOfKNumber(sum -n, n - 1);
        list.remove(list.size() - 1);
        sumOfKNumber(sum, n - 1);
    }

    public static void main(String[] args) {
        SumOfKNumber inst = new SumOfKNumber();
        inst.sumOfKNumber(8, 5);
        System.out.println("There are " + inst.count + " possibilities");
    }
}
