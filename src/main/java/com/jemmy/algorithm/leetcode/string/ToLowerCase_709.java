package com.jemmy.algorithm.leetcode.string;

/**
 * 709. 转换成小写字母
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/22
 */
public class ToLowerCase_709 {

    public String toLowerCase(String str) {
        // Clarification: 转成小写字母
        // 方案1: 使用系统函数

        return str.toLowerCase();
    }

    public String toLowerCaseTwo(String str) {
        // 方案2: 利用字符的ASCII值
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ToLowerCase_709 instance = new ToLowerCase_709();
        String result = instance.toLowerCaseTwo("HellO");
        System.out.println(result);
    }
}
