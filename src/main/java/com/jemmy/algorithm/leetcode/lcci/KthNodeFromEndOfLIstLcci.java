package com.jemmy.algorithm.leetcode.lcci;

import com.jemmy.algorithm.everyday.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/9
 */
public class KthNodeFromEndOfLIstLcci {

    public int kthToLast(ListNode head, int k) {
        // Clarification: 返回倒数第k个节点的值
        // 方案1: 先遍历计算节链表的长度 count ，然后遍历到第 count - k 个节点，返回其值
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int count = 0;
        ListNode curr = head;
        while (curr !=  null) {
            count++;
            curr = curr.next;
        }

        int i = 0, target = count - k;
        ListNode targetNode = head;
        while (i++ < target) {
            targetNode = targetNode.next;
        }

        return targetNode.val;
    }

    public int kthToLastTwo(ListNode head, int k) {
        // 方案2: 双指针 a, b，分别指向开始和第 k 个节点，然后一起往后移动，直到 b 的后继为 null，a 指向节点的值即为所求

        ListNode a = head, b = head;
        int i = 0;
        while (i++ < k) {
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        return a.val;
    }
}
