package com.jemmy.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhujiang.cheng
 * @since 2020/6/23
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // 方案1：使用栈来处理
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        // 问题: 遇到不符要求的括号，没有快速return
        if (s == null || s.length() == 0) {
            return true;
        }

        LinkedList<Character> list = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (list.size() == 0) {
                list.push(chs[i]);
            } else {
                Character ch = list.peek();
                if (ch == '{' && chs[i] == '}'
                    || ch == '[' && chs[i] == ']'
                    || ch == '(' && chs[i] == ')') {
                    list.pop();
                } else {
                    list.push(chs[i]);
                }
            }
        }

        return list.size() == 0;
    }

    public boolean isValid_2(String s) {
        // 方案2：方案1优化：快速return
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        if (s == null || s.length() == 0) {
            return true;
        }

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '}' || ch == ']' || ch == ')') {
                if (list.size() == 0) {
                    return false;
                }

                Character cha = list.peek();
                if (cha == '{' && ch == '}' || cha == '[' && ch == ']' || cha == '(' && ch == ')') {
                    list.pop();
                } else {
                    return false;
                }
            } else {
                list.push(ch);
            }
        }

        return list.size() == 0;
    }

    public boolean isValid_3(String s) {
        // 方案3：map存储括号对
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        if (s == null || s.length() == 0) {
            return true;
        }
        // 字符串长度为奇数时，直接返回false
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(4);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character ch = stack.peek();
            char c = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;
    }

    public boolean isValid_3Plus(String s) {
        // 方案3：map存储括号对，快速返回false
        // 时间复杂度: O(N)
        // 空间复杂度: O(N)
        if (s == null || s.length() == 0) {
            return true;
        }
        // 字符串长度为奇数时，直接返回false
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(4);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                Character ch = stack.peek();
                if (map.containsKey(ch) && map.get(ch) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses inst = new ValidParentheses();
        boolean result = inst.isValid("()");
        System.out.println(result);
    }
}
