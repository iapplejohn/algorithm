package com.jemmy.algorithm.leetcode.string;

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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/22
 */
public class JewelsAndStones_771 {

    public int numJewelsInStones(String J, String S) {
        // Clarification: 统计宝石的个数，J为宝石的类型，S为拥有的石头
        // 方案1：两重循环
        // 时间复杂度: O(m*n)
        // 空间复杂度: O(1)

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numJewelsInStonesTwo(String J, String S) {
        // 方案2：将J中的字符放到哈希表中，方便查询
        // 时间复杂度: O(n)
        // 空间复杂度: O(m)

        int count = 0;
        int capacity = (int) (J.length() / 0.75);
        Set<Character> set = new HashSet<>(capacity);
        for (int j = 0; j < J.length(); j++) {
            set.add(J.charAt(j));
        }

        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
