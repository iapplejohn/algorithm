package com.jemmy.algorithm.leetcode.sword;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/17
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Clarification: 合并两个升序链表为一个升序链表
        // 方案1: 递归，如果 l1 比 l2 小，问题变成 l1.next 和 l2比较，存在相似性
        // 时间复杂度: O(m + n)
        // 空间复杂度: O(m + n)

        // terminator
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // process current logic
        // drill down
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        // 方案2: 迭代，使用 dummy 节点
        // 时间复杂度: O(m + n)
        // 空间复杂度: O(1)

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 链表不等长处理, l1 和 l2 其中一个可能不为 null
        prev.next = l1 == null ? l2 : l1;

        return dummyNode.next;
    }
}
