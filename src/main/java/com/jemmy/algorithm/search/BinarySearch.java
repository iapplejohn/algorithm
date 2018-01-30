/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: BinarySearch.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/1 15:26
 * Description: 
 */
package com.jemmy.algorithm.search;

/**
 * BinarySearch
 *
 * @author Cheng Zhujiang
 * @date 2017/7/1
 */
public class BinarySearch {

    // 加减1特别重要:减少比较,防止死循环
    public static int binarySearch(int[] arr, int n, int data) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);

            if (data > arr[middle]) {
                left = middle + 1;
            } else if (data < arr[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 28, 57, 96, 125};
        int pos = binarySearch(arr, 6, 7);
        System.out.println(pos);
    }
}
