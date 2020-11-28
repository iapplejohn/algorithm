package com.jemmy.algorithm.leetcode.string;

import java.util.LinkedList;

/**
 * 844. 比较含退格的字符串
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/19
 */
public class BackspaceStringCompare_844 {

    public boolean backspaceCompare(String S, String T) {
        // Clarification: 比较含退格的字符串
        // 方案1: 使用栈辅助 将字符依次入栈，遇到#，出栈，然后判断两个栈的字符是否相等
        // 时间复杂度: O(m + n)
        // 空间复杂度: O(m + n)

        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(S.charAt(i));
            }
        }

        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(T.charAt(j));
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public boolean backspaceComparePlus(String S, String T) {
        // 方案1': 使用 StringBuilder 替代栈，构建字符串

        return build(S).equals(build(T));
    }

    private String build(String s) {
        StringBuilder builder = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }

    public boolean backspaceCompareTwo(String S, String T) {
        // 方案2: 双指针 决定一个字符是否删除，是由后面的字符决定的，所以从后往前遍历
        // 时间复杂度: O(m + n)
        // 空间复杂度: O(1)

        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // 先处理跳格和对应的字符
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // 比较当前位置字符
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i > 0 || j > 0) {
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }
}
