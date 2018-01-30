/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: SwitchVariable.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/2 15:48
 * Description: 
 */
package com.jemmy.algorithm.badboy;

/**
 * 互换两个变量（不使用中间变量）
 *
 * @author Cheng Zhujiang
 * @date 2017/7/2
 */
public class SwitchVariable {

    // 可能越界
    private static void doSwitchViaAdd(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + ",b=" + b);
    }

    // 只适用于整数
    // a、b异或的结果 ，和a异或得b ，和b异或得a
    private static void doSwitchViaExclusiveOr(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void main(String[] args) {
        int a = 58, b = 69;
        doSwitchViaAdd(a, b);
        doSwitchViaExclusiveOr(a, b);
    }
}
