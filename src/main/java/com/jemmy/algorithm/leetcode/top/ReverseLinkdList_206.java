package com.jemmy.algorithm.leetcode.top;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/2
 */
public class ReverseLinkdList_206 {

    public ListNode reverseList(ListNode head) {
        // Clarification: 反转单链表
        // 方案1：递归

        if (head == null) {
            return null;
        }

        // 假设链表是[1, 2, 3, 4, 5]从最底层最后一个reverseList(5)来看
        //返回了5这个节点
        //reverseList(4)中
        //p为5
        //head.next.next = head 相当于 5 -> 4
        //现在节点情况为 4 -> 5 -> 4
        //head.next = null,切断4 -> 5 这一条，现在只有 5 -> 4
        //返回（return）p为5，5 -> 4
        //返回上一层reverseList(3)
        //处理完后返回的是4 -> 3
        //依次向上
        return recursive(head);
    }

    private ListNode recursive(ListNode node) {
        // terminator
        if (node.next == null) {
            return node;
        }

        // drill down: 需要先递归后尾部，然后再回溯，处理 next 指针；p 一直都是尾节点
        ListNode p = recursive(node.next);

        // process current logic
        node.next.next = node;
        node.next = null;

        // reverse current states
        return p;
    }

    // 方案2：迭代
}
