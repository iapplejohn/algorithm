package com.jemmy.algorithm.leetcode;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author zhujiang.cheng
 * @since 2020/9/24
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {

    public int[] reversePrint(ListNode head) {
        // Clarification: 从尾到头打印链表
        // 方案1：迭代 列表再反转

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            res[list.size() - 1 - i] = list.get(i);
        }

        return res;
    }

    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrintTwo(ListNode head) {
        // Clarification: 从尾到头打印链表
        // 方案2：递归 + 回溯

        recursive(head);

        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }

    private void recursive(ListNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        // drill down
        recursive(node.next);

        // back track
        tmp.add(node.val);

        // reverse current states
    }

    public int[] reversePrintThree(ListNode head) {
        // 方案3: 栈辅助

        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] =stack.pop();
        }

        return res;
    }
}
