package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/13
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        // Clarification: 两两交换链表中的节点
        // 方案1: 递归

        // terminator
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        // drill down
        ListNode temp = swapPairs(next.next);

        // process current logic
        head.next = temp;
        next.next = head;

        // reverse current states
        return next;
    }

    public ListNode swapPairsTwo(ListNode head) {
        // 方案2 迭代 使用 dummy 节点辅助

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        // 两两交换节点
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            // 交换三部曲
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1.next;

            // temp 指向下一个节点
            temp = node1;
        }

        return dummyHead.next;
    }
}
