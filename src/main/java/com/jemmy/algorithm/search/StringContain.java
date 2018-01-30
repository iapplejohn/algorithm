/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: StringContain.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/2 16:40
 * Description: 
 */
package com.jemmy.algorithm.search;

/**
 * StringContain
 *
 * @author Cheng Zhujiang
 * @date 2017/7/2
 */
public class StringContain {

    // 时间复杂度O(n * m)，最好时间复杂度O(n)
    public static int indexOf(String strA, String strB) {
        char[] a = strA.toCharArray(), b = strB.toCharArray();
        int sourceCount = a.length, destCount = b.length;
        int max = sourceCount - destCount;

        for (int i = 0; i <= max; i++) {
            int j = i;
            int end = i + destCount;

            for (int k = 0; j < end && a[j] == b[k]; j++, k++);

            if (j == end) {
                return i;
            }
        }

        return -1;
    }

    // 如果不是取连续字符串,先对两个字符串进行快速排序，时间复杂度O(m log m) + O(n log n)，然后再比较，时间复杂度O(m + n)


    // 如果不是判断连续字符串,把字符串a的字符都放到HashSet,然后判断字符串b中的字符是否都在a中


    // 如果不是判断连续字符串，且字符串都是26个字母，利用基准数字将字符串a替换成质数，并相乘，查看是否能被b中的整除

    public static void main(String[] args) {
        String strA = "bcdrdeshinl";
        String strB = "ngggggggggg";
        int index = indexOf(strA, strB);
        System.out.println(index);
    }
}
