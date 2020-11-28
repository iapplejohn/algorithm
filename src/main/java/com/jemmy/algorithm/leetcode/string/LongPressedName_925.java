package com.jemmy.algorithm.leetcode.string;

/**
 * 925. 长按键入
 *
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *  
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/21
 */
public class LongPressedName_925 {

    public boolean isLongPressedName(String name, String typed) {
        // Clarification: name 为姓名，typed 为键入字符，某些字符可能敲多次，但不能少
        // 方案1: 双指针法，先判断是否相同，如果不相同，是否和前一个字符相同

        int len1 = name.length(), len2 = typed.length();
        int i = 0, j = 0;
        while (j < len2) {
            // 判断两个字符是否相同: 加上 i < len1 是防止 name.charAt(i) 越界
            if (i < len1 && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
                // 判断是否和上一个typed字符相同，加上 j > 0 是防止 j - 1 越界
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }

        // 针对遍历完 typed，name 还没遍历完情况
        return i == len1;
    }
}
