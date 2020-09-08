package com.jemmy.algorithm.leetcode.top;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.ArrayList;
import java.util.List;

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
 * @since 2020/9/7
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        // Clarification: 判断是否回文链表
        // 方案1: 数组 + 双指针
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

        // 方案2: 递归
        // 方案3: 反转后半部分链表
}
