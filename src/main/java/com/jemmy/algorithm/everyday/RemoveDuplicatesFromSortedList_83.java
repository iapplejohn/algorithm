package com.jemmy.algorithm.everyday;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/24
 */
public class RemoveDuplicatesFromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {
        // Clarification: 从排序链表中删除重复元素
        // 方案1: 比较当前和前一个节点的值，如果相等，删除当前节点：将前一个节点的后继指针指向下个节点
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            ListNode curr = prev.next;
            if (curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesPluus(ListNode head) {
        // 方案2：比较当前和后一个节点的值，如果相等，删除后一个节点：将当前节点的后继指针指向下下个节点
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
