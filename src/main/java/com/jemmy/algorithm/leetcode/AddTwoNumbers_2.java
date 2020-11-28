package com.jemmy.algorithm.leetcode;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/4
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Clarification: 两个链表分别代表两个数（从低位到高位），相加，使用链表存储
        // 方案1: 直接相加，从低向高进位
        // 进位使用boolean（不会超过20），使用dummy节点

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        boolean carryBit = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            if (carryBit) {
                sum += 1;
            }

            if (sum >= 10) {
                carryBit = true;
                sum -= 10;
            } else {
                carryBit = false;
            }

            ListNode node = new ListNode(sum);
            curr.next = node;

            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carryBit) {
            ListNode node = new ListNode(1);
            curr.next = node;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbersPlus(ListNode l1, ListNode l2) {
        // 方案1': 直接相加，从低向高进位
        // 进位使用整型，使用头尾节点

        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
