package com.jemmy.algorithm.leetcode.math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/15
 */
public class RemoveKDigits_402 {

    public String removeKdigits(String num, int k) {
        // Clarification: 以字符串表示的非负整数，移除k位数字，使得剩下的数字最小
        // 方案1：从左向右遍历，如果比前一个数字小，就去掉前一个数字，否则保留

        // 使用栈，方便在顶部 push 或 pop
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            // 这里必须是 while，而不是 if，否则不能处理 "1234567890" 9 场景
            while (!deque.isEmpty() && k > 0 && num.charAt(i) < deque.peekLast()) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i));
        }

        for (int j = 0; j < k; j++) {
            deque.pollLast();
        }

        StringBuilder builder = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            Character ch = deque.pollFirst();
            if (leadingZero && ch == '0') {
                continue;
            }
            leadingZero = false;
            builder.append(ch);
        }

        if (builder.length() == 0) {
            return "0";
        } else {
            return builder.toString();
        }
    }
}
