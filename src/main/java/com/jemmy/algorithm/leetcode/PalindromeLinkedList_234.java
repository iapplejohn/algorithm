package com.jemmy.algorithm.leetcode;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.ArrayList;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/24
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        // Clarification: 判断是否回文链表
        // 方案1：数组+双指针，先存到数组中，然后首尾指针遍历

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private ListNode frontPointer;

    public boolean isPalindromeTwo(ListNode head) {
        // 方案2 递归 传入 next 节点，一直到末尾，在回溯的时候，current 和 frontPointer 的值进行比较，如果不相等返回false，
        // frontPointer 往后
        // 递归参数：下一个节点

        frontPointer = head;
        return recursive(head);
    }

    private boolean recursive(ListNode current) {
        // terminator
        if (current == null) {
            return true;
        }

        // drill down
        boolean result = recursive(current.next);
        if (!result) {
            return false;
        }

        // process current logic
        if (current.val != frontPointer.val) {
            return false;
        }
        frontPointer = frontPointer.next;

        // reverse current states

        return true;
    }
}
