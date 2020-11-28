package com.jemmy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/2
 */
public class JewelsAndStones_771 {

    public int numJewelsInStones(String J, String S) {
        // Clarification: J代表宝石类型，不重复，S为拥有的石头，求宝石多少个
        // 方案1: 双重循环
        // 时间复杂度: O(n * m)
        // 空间复杂度: O(1)

        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            char ch = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (ch == S.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numJewelsInStonesTwo(String J, String S) {
        // 方案2: 哈希表

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int j = 0; j < S.length(); j++) {
            if (set.contains(S.charAt(j))) {
                count++;
            }
        }

        return count;
    }
}
