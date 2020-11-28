package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/20
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        // Clarification: 对单链表进行插入排序
        // 方案1：从前往后找插入点

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // lastSorted 指针比较关键
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            // 当前节点值比有序段末尾节点大，将 lastSorted 指向当前节点
            if (cur.val >= lastSorted.val) {
                lastSorted = cur;
                // lastSorted = lastSorted.next;
            } else {
                // 有序段：从前往后找插入点
                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }

                // 指针替换
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            // cur 可能已经放到有序段的前面，不能用 cur.next
            cur = lastSorted.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        InsertionSortList_147 instance = new InsertionSortList_147();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode sortedHead = instance.insertionSortList(head);
        System.out.println(sortedHead);
    }

}
