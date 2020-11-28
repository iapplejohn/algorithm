package com.jemmy.algorithm.leetcode.sword;

import com.jemmy.algorithm.everyday.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/10
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Clarification: 返回两个链表的第一个公共节点，如果没有，返回 null
        // 方案1: 哈希表，先记录第一个链表的节点，然后遍历第二个链表，判断节点是否存在于哈希表中
        // 时间复杂度: O(n) n 为链表长度
        // 空间复杂度: O(n)

        Set<ListNode> set = new HashSet<>();
        ListNode a = headA;
        while (a != null) {
            set.add(a);
            a = a.next;
        }

        ListNode b = headB;
        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        // 方案2: 双指针 分别指向链表头部，一起往后遍历，如果到达尾部，指向另一个链表的头部，继续往后遍历，直到相等

        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }

            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }

        return pa;
    }
}