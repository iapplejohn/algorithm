package com.jemmy.algorithm.leetcode;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/9
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // Clarification: 获取链表中倒数第 k 个节点
        // 方案1: 先遍历获取链表的长度，然后遍历到第 n - k 个节点

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int i = 0, target = count - k;
        ListNode targetNode = head;
        while (i++ < target) {
            targetNode = targetNode.next;
        }

        return targetNode;
    }

    public ListNode getKthFromEndTwo(ListNode head, int k) {
        // 方案2: 双指针: a 初始指向起始位置，b 初始指向第 k 个位置，然后一起往后移动，当b 到达末尾时，a即为所求

        ListNode a = head, b = head;
        int i = 0;
        while (i++ < k) {
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
