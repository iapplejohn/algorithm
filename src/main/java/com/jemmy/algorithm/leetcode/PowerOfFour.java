package com.jemmy.algorithm.leetcode;

/**
 * @author zhujiang.cheng
 * @since 2020/6/6
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }

        while (num % 4 == 0) {
            num /= 4;
        }

        return num == 1;
    }

    public boolean isPowerOfFour_2(int num) {
        // 方案2: 转换为以基数4为底的数，是否以1开头,多个0(可能没有)结束
        if (num < 1) {
            return false;
        }

        String val = Integer.toString(num, 4);
        return val.matches("^10*$");
    }

    public boolean isPowerOfFour_3(int num) {
        // 方案3: 运算法: Math.log10(n) / Math.log10(4) 为整数
        if (num < 1) {
            return false;
        }

        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }

    public boolean isPowerOfFour_32(int num) {
        // 方法6: 数学运算
        return num > 0 && (Math.log(num) / Math.log(2)) % 2 == 0;
    }

    public boolean isPowerOfFour_7(int num) {
        // 方法7: 位运算
        return num > 0 && (num & (num -1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }

    public boolean isPowerOfFour_8(int num) {
        // 方法8: 位运算+数学运算
        return num > 0 && (num & (num -1)) == 0 && num % 3 == 1;
    }

//    public boolean isPowerOfFour_4(int num) {
//        // 方案4: 找到最大的被4整除的数
//        if (num < 1) {
//            return false;
//        }
//
//
//
//
//    }

    public static void main(String[] args) {
        System.out.println(Math.log(64));
    }
}
