package com.jemmy.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujiang.cheng
 * @since 2020/6/13
 */
public class RemoveDuplicatesFromString {

    private ArrayDeque<Character> stack = new ArrayDeque<>();

    public String removeDuplicates(String S) {
        // 方案1: 使用stack处理，将第一个字符串入栈
        stack.push(S.charAt(0));

        // 拿第二个字符，和栈顶元素比较：相同则出栈，不同则入栈
        // 拿第三个字符，重复上面的操作...
        for (int i = 1; i < S.length(); i++) {
            if (stack.size() > 0 && S.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }

        // 拿栈里面的字符串，就是需要的结果
        int j = 0;
        int len = stack.size();
        char[] chars = new char[len];
        while (j < len) {
            Character ch = stack.pollLast();
            chars[j] = ch;
            j++;
        }

        return new String(chars);
    }

    public String removeDuplicates_2(String S) {
        // 方案2: 使用stack(StringBuilder)处理
        StringBuilder builder = new StringBuilder();

        builder.append(S.charAt(0));

        // 拿第二个字符，和builder最后一个元素比较：相同则删除builder最后一个元素，不同则追加
        // 拿第三个字符，重复上面的操作...
        for (int i = 1; i < S.length(); i++) {
            if (builder.length() > 0 && S.charAt(i) == builder.charAt(builder.length() - 1)) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(S.charAt(i));
            }
        }

        return builder.toString();
    }

    public String removeDuplicates_3(String S) {
        // 方案3: 使用stack(List)处理
        List<Character> list = new ArrayList<>();

        list.add(S.charAt(0));

        // 拿第二个字符，和list最后一个元素比较：相同则删除list最后一个元素，不同则追加
        // 拿第三个字符，重复上面的操作...
        for (int i = 1; i < S.length(); i++) {
            if (list.size() > 0 && S.charAt(i) == list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
            } else {
                list.add(S.charAt(i));
            }
        }

        char[] chars = new char[list.size()];
        for (int j = 0; j < list.size(); j++) {
            chars[j] = list.get(j);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromString instance = new RemoveDuplicatesFromString();
        String result = instance.removeDuplicates("abbaca");
        System.out.println("result = " + result);
    }
}
