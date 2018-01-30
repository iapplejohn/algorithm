/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: Juseph.java
 * Author:   Cheng Zhujiang
 * Date:     2017/11/4 21:22
 * Description: 
 */
package com.jemmy.algorithm.list;

/**
 * <pre>
 * Juseph
 *
 * @author Cheng Zhujiang
 * @date 2017/11/4
 */
public class Juseph {

    public static void main(String[] args) {
        CycleList cycleList = new CycleList();
        cycleList.setSize(10);
        cycleList.setBeginNum(5);
        cycleList.setM(5);
        cycleList.createList();
        cycleList.showList();
        cycleList.start();
    }
}
