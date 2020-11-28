package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/18
 */
public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Clarification: 删除单链表的倒数第 n 个节点
        // 方案1: 计数法，先统计节点的个数 count，然后遍历到 count - n - 1 个节点，将其指针指向下下个节点

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        if (count == n) {
            head = head.next;
        } else {
            int prev = count - n - 1;
            ListNode prevNode = head;
            while (--prev >= 0) {
                prevNode = prevNode.next;
            }

            ListNode targetNode = prevNode.next;
            prevNode.next = targetNode.next;
            targetNode.next = null;
        }
        return head;
    }

    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        // 方案2: 双指针法，右指针先指向第 n 个节点，左指针指向 head，然后一起往右，直到末尾

        ListNode pl = head, pr = head;
        int i = 0;
        while (i++ < n) {
            pr = pr.next;
        }

        // 删除第一个节点
        if (pr.next == null) {
            head = head.next;
        } else {
            // 再往右移一位
            pr = pr.next;

            // 左右指针一起移动，直到右指针到末尾
            while (pr != null) {
                pl = pl.next;
                pr = pr.next;
            }

            pl.next = pl.next.next;
        }

        return head;
    }
}
