package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 148. 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/21
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
        // Clarification:
        // 方案1：递归（快慢指针分拆 + 归并排序）
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(1)

        // terminator
        if (head == null || head.next == null) {
            return head;
        }

        // process current logic
        // 快慢指针找到奇数/偶数节点个数的中点/中点左边节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 分拆
        ListNode rightHead = slow.next;
        slow.next = null;

        // drill down
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // reverse current states
        // 归并排序，对于链表，使用 dummy head
        ListNode p = new ListNode(-1);
        ListNode res = p;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        // 处理剩余链表(两个链表中的一个)
        p.next = left != null ? left : right;

        return res.next;
    }

}
