package com.jemmy.algorithm.huawei;

import java.util.Scanner;

/**
 * 素数是指在一个大于1的自然数中，除了1和此整数自身外，不能被其他自然数整除的数。
 *
 * 给定两个数字m和n，统计这两个数字之间素数的个数。
 *
 * 输入为两个整数：m和n
 * 输出m和n之间的素数的个数
 *
 * 样例输入:
 * 0 10
 *
 * 样例输出:
 * 4
 *
 * @author zhujiang.cheng
 * @since 2020/2/23
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("给定两个数字，以空格分隔");
        while (scanner.hasNext()) {
            String[] strArr = scanner.nextLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            int count = countPrime(a, b);
            System.out.println(count);
        }
    }

    private static int countPrime(int a, int b) {
        int count = 0;
        for (int n = a; n <= b; n++) {
            if (isPrime(n)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        double j = Math.sqrt(n);
        for (int i = 2; i <= j; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
