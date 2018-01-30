/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: Fibonacci.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/6 17:30
 * Description: 
 */
package com.jemmy.algorithm.july.array;

/**
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 * <p>
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 *
 * @author Cheng Zhujiang
 * @date 2017/7/6
 */
public class Fibonacci {

    static long getFibonacci2(int n) {
        int[] results = {0, 1, 2};
        if (n <= 2) {
            return results[n];
        }

        return getFibonacci2(n - 1) + getFibonacci2(n - 2);
    }

    /**
     * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级，也可以条3级
     * <p>
     * 求总共有多少总跳法，并分析算法的时间复杂度。
     */
    static long getFibonacci3(int n) {
        int[] results = {0, 1, 2, 4};
        if (n <= 3) {
            return results[n];
        }

        return getFibonacci3(n - 1) + getFibonacci3(n - 2) + getFibonacci3(n - 3);
    }

    /**
     * 解法二
     * 解法一用的递归的方法有许多重复计算的工作，事实上，我们可以从后往前推，一步步利用之前计算的结果递推。
     * <p>
     * 初始化时，dp[0]=dp[1]=1，然后递推计算即可：dp[n] = dp[n-1] + dp[n-2]。
     */
    static long climbStairs(int n) {
        int[] dp = { 1, 1, 0};

        for (int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci2(10));
        System.out.println(getFibonacci3(10));
        System.out.println(climbStairs(10));
    }
}
