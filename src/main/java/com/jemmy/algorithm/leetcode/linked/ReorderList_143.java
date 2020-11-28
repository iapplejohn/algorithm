package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/20
 */
public class ReorderList_143 {

    public void reorderList(ListNode head) {
        // Clarification: 重排链表
        // 方案1：使用列表辅助，将所有节点存到列表中，然后改变链
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            ListNode left = list.get(l);
            ListNode right = list.get(r);
            ListNode lNext = left.next;
            left.next = right;
            if (lNext != right) {
                right.next = lNext;
            }
            l++;
            r--;
        }

        // 边界值处理: 包括 l==r 和 l>r
        if (list.size() > 0) {
            list.get(l).next = null;
        }
    }

    public void reorderListTwo(ListNode head) {
        // 方案2：递归
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 求链表长度
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        recursive(head, len);
    }

    private ListNode recursive(ListNode node, int len) {
        // terminator
        if (len == 1) {
            ListNode outTrail = node.next;
            node.next = null;
            return outTrail;
        }
        if (len == 2) {
            ListNode outTrail = node.next.next;
            node.next.next = null;
            return outTrail;
        }

        // drill down
        // 指针每次挪一位，长度每次减2位，最后找到中间的1或两个节点，拿到 outTrail
        ListNode tail = recursive(node.next, len - 2);
        // process current logic
        ListNode subHead = node.next;
        node.next = tail;
        ListNode outTrail = tail.next;
        tail.next = subHead;

        return outTrail;
    }

    public void reorderListThree(ListNode head) {
        // 方案3: 分两部分 第二个链表逆序 依次连接

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 找中点
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 右半边的链表
        ListNode rightHead = slow.next;
        slow.next = null;

        // 第二个链表倒置
        rightHead = reverseLinked(rightHead);

        // 链表节点依次连接
        while (rightHead != null) {
            ListNode rightNext = rightHead.next;
            rightHead.next = head.next;
            head.next = rightHead;
            head = rightHead.next;
            rightHead = rightNext;
        }
    }

    private ListNode reverseLinked(ListNode head) {
        // 方案1：迭代，处理相邻两个节点的指针，保留下一个节点

        if (head == null) {
            return null;
        }

        // head 指向下一个节点，tail 指向第一个节点
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = tail;

            tail = head;
            head = next;
        }

        // head 为 null，需要拿前一个节点 tail
        return tail;
    }
}
