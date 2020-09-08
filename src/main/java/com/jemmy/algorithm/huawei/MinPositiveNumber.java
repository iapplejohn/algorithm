package com.jemmy.algorithm.huawei;

/**
 * 【题目】: 给定一个无序整型数组arr，找到数组中未出现的最小正整数。要求时间复杂度为O(N)，空间复杂度为O(1)。
 *
 * 例如：
 *
 * arr=[-1,2,3,4]。返回1。
 *
 * arr=[1,2,3,4]。返回5。
 *
 * https://blog.csdn.net/zxc123e/article/details/49363623
 *
 * @author zhujiang.cheng
 * @since 2020/2/23
 */
public class MinPositiveNumber {

    static int missMinNum(int arr[]) {
        int l = 0;
        int r = arr.length;
        int temp;

        while (l < r) {
            if (arr[l] == l + 1) { // 自然增长数组, 1,2,3...N
                l++;
            } else if (arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]) { // 不合法
                arr[l] = arr[--r];
            } else { // 合法但是没有在理想的位置上
                temp = arr[l];
                arr[l] = arr[arr[l] - 1];
                arr[temp - 1] = temp;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -5, 1, 90, 2 };
        int number = missMinNum(arr);
        System.out.println(number);
    }
}
