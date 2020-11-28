package com.jemmy.algorithm.leetcode.sword;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/20
 */
public class FanZhuanLianBiaoLcof {

    public ListNode reverseList(ListNode head) {
        // Clarification: 反转链表
        // 方案1：递归

        if (head == null) {
            return null;
        }

        return recursive(head);
    }

    private ListNode recursive(ListNode node) {
        // terminator
        if (node.next == null) {
            return node;
        }

        // drill down 先递归直至最末节点
        ListNode newHead = recursive(node.next);

        // process current logic
        node.next.next = node;
        node.next = null;

        // 返回 next 节点，即新的 head 节点，一直返过去
        return newHead;
    }

    public ListNode reverseListTwo(ListNode head) {
        // 方案2：迭代

        if (head == null) {
            return null;
        }

        // 初始化新的 head 为 下一个节点，tail 为第一个节点
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;

            tail = head;
            head = temp;
        }

        // head 为 null，tail 为最后一个节点，即新的 head 节点
        return tail;
    }
}
