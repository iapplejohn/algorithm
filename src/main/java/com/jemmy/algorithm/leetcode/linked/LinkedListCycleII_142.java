package com.jemmy.algorithm.leetcode.linked;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *  
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/10
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {
        // Clarification: 判断链表是否有环，返回入环的第一个节点，否则返回 null
        // 方案1: 哈希表 记录访问过的节点，如果遍历到后面还能访问该节点，则该节点为所求

        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            } else {
                set.add(curr);
                curr = curr.next;
            }
        }

        return null;
    }

    public ListNode detectCycleTwo(ListNode head) {
        // 方案2: 快慢指针
        // 第一轮相遇，fast 走了 2nb (b 为环长），slow 走了 nb
        // 构造第二轮相遇，fast 从head出发，每次走一步，走 a 步 (入环前长度），slow 也走 a 步
        // 此时 f = a, s = a + nb，在入环点相遇

        if (head == null) {
            return null;
        }

        // fast, slow 初始值不同
        ListNode fast = head, slow = head;

        // 第一次相遇：无环的时候，循环不能终止，所以内部要加退出逻辑
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // 构造第二次相遇
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
