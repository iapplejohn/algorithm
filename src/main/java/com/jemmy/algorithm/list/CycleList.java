/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: SysLink.java
 * Author:   Cheng Zhujiang
 * Date:     2017/11/4 20:11
 * Description: 
 */
package com.jemmy.algorithm.list;

/**
 * <pre>
 * CycleList
 *
 * @author Cheng Zhujiang
 * @date 2017/11/4
 */
public class CycleList {

    private Node firstNode;

    private Node temp;

    private int size;

    private int beginNum;

    private int m;

    public void setSize(int size) {
        this.size = size;
    }

    public void setBeginNum(int beginNum) {
        this.beginNum = beginNum;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void createList() {
        for (int i = 1; i <= size; i++) {
            if (i == 1) {
                Node node = new Node(i);
                firstNode = node;
                temp = node;
                node.next = firstNode;
            } else {
                if (i != size) {
                    Node node = new Node(i);
                    temp.next = node;
                    temp = node;
                } else {
                    Node node = new Node(i);
                    temp.next = node;
                    temp = node;
                    node.next = firstNode;
                }
            }
        }
    }

    public void start() {
        // 找到开始数的节点
        Node temp = this.firstNode;
        for (int i = 1; i < beginNum; i++) {
            temp = temp.next;
        }
        while (size != 1) {
            for (int i = 1; i < m; i++) {
                temp = temp.next;
            }

            Node temp2 = temp;
            while (temp2.next != temp) {
                temp2 = temp2.next;
            }

            // 去除temp节点
            temp2.next = temp.next;
            System.out.println("出圈的人是:" + temp.num);

            temp = temp.next;
            size--;
        }
        System.out.println("最后剩下的是:" + temp.num);
    }

    public void showList() {
        Node temp = firstNode;
        if (temp.next.num == 1) {
            System.out.println(temp.num);
        } else {
            while (temp.next != firstNode) {
                System.out.println(temp.num);
                temp = temp.next;
            }
        }
        System.out.println(temp.num);
    }
}

class Node {
    int num;
    Node next;

    public Node(int num) {
        this.num = num;
    }
}
