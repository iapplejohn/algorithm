package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 328. 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/13
 */
public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        // Clarification: 单链表，奇数节点和偶数节点分别排在一起，第一个为奇数节点
        // 方案1：使用额外的两个链表，分别存储奇偶节点，然后将奇数节点的next指向偶数节点的开头

        ListNode oddHead = new ListNode(-1), odd = oddHead, cur = head;
        ListNode evenHead = new ListNode(-1), even = evenHead;
        boolean bOdd = true;

        while (cur != null) {
            if (bOdd) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }

            bOdd = !bOdd;
            cur = cur.next;
        }

        // 尾部处理
        if (bOdd) {
            odd.next = null;
        } else {
            even.next = null;
        }

        odd.next = evenHead.next;
        ListNode res = oddHead.next;
        oddHead.next = null;
        evenHead.next = null;

        return res;
    }

    public static void main(String[] args) {
        OddEvenLinkedList_328 inst = new OddEvenLinkedList_328();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ListNode res = inst.oddEvenListTwo(head);
        System.out.println(res);
    }

    public ListNode oddEvenListTwo(ListNode head) {
        // 方案2：直接在原链表上修改指针

        ListNode cur = head, odd = head;
        ListNode evenHead = null, even = null;
        boolean bOdd = true;

        while (cur != null) {
            // 通过指定 next 构成新的链
            ListNode next = cur.next;
            if (next != null) {
                cur.next = next.next;
            }

            if (bOdd) {
                // 最近一个奇数位置
                odd = cur;
            } else {
                even = cur;
                if (evenHead == null) {
                    evenHead = cur;
                }
            }

            bOdd = !bOdd;
            cur = next;
        }

        // 尾部处理
        if (bOdd) {
            even.next = null;
        }

        // 奇数末尾节点的next指向偶数的头节点
        odd.next = evenHead;

        return head;
    }

    public ListNode oddEvenListThree(ListNode head) {
        // 方案2'：分离节点后合并

        if (head == null) {
            return head;
        }

        ListNode odd = head, evenHead = head.next, even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
