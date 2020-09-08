package com.jemmy.algorithm.everyday;

import java.util.Arrays;

/**
 * 190. 颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/13
 */
public class ReverseBits {

    public int reverseBits(int n) {
        // Clarification: 输入一个整数，将其二进制位颠倒后，转成整数返回
        // 方案1: 暴力 需要使用 parse/toUnsignedString
        String binaryStr = Integer.toUnsignedString(n, 2);
        char[] target = new char[32];
        char[] chars = binaryStr.toCharArray();
        Arrays.fill(target, 0, 32 - chars.length, '0');
        System.arraycopy(chars, 0, target, 32 - chars.length, chars.length);
        for (int i = 0, len = target.length; i < (len >> 1); i++) {
            swap(target, i, len - i -  1);
        }

        return Integer.parseUnsignedInt(new String(target), 2);
    }

    private void swap(char[] target, int i, int j) {
        char temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }

    public int reverseBitsTwo(int n) {
        // 方案2: 循环 + 移位
        int result = 0, power = 31;
        while (n > 0) {
            // 拿到最后一位的值，放到前面
            result += (n & 1) << power;
            // 每次将数字整体右移一位
            n = n >> 1;
            power--;
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 0b11111111111111111111111111111101;
        ReverseBits instance = new ReverseBits();
        int result = instance.reverseBits(x);
        System.out.println(result);

//        int x = Integer.valueOf("00000010100101000001111010011100", 2);
//        System.out.println(x);
    }

}
