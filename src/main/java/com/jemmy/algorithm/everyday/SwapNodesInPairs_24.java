package com.jemmy.algorithm.everyday;

/**
 * @author zhujiang.cheng
 * @since 2020/8/14
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        // Clarification: 两两交换链表中的节点
        // 方案1: 递归

        // 链表为空或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        // 下面的次序不能变
        head.next = swapPairs(next.next);
        next.next = head;

        // 交换节点后，next 在前面
        return next;
    }

}
