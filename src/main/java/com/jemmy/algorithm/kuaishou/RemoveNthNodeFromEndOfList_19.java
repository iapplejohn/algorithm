package com.jemmy.algorithm.kuaishou;

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
 * @since 2020/10/9
 */
public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Clarification: 删除单链表的倒数第 N 个节点
        // 方案1: 先遍历链表计算长度，然后遍历到第 count - n - 1节点，将其 next 指针指向下下个节点

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        // 删除头节点
        if (count == n) {
            head = head.next;
        } else {
            int i = 0, target = count - n - 1;
            ListNode prev = head;
            while (i++ < target) {
                prev = prev.next;
            }

            ListNode targetNode = prev.next;
            prev.next = targetNode.next;
        }

        return head;
    }

    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        // 方案2: 双指针，a 和 b 分别指向开始和第 n + 1 个节点，然后一起往后移动，直到b的后继为 null，a 即为待删除节点的前一个节点

        ListNode a = head, b = head;

        int i = 0;
        while (i++ < n) {
            b = b.next;
        }

        // 删除头节点
        if (b == null) {
            head = head.next;
        } else {
            // 往后再移动一个节点
            b = b.next;

            while (b != null) {
                a = a.next;
                b = b.next;
            }

            a.next = a.next.next;
        }

        return head;
    }
}
