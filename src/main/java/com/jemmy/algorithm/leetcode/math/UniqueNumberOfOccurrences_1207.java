package com.jemmy.algorithm.leetcode.math;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1207. 独一无二的出现次数
 *
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/28
 */
public class UniqueNumberOfOccurrences_1207 {

    public boolean uniqueOccurrences(int[] arr) {
        // Clarification: 数字出现次数不同，返回true，否则false
        // 方案1：哈希表
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        HashMap<Integer, Integer> digitCounts = new HashMap<>(arr.length);
        HashSet<Integer> countSet  = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            digitCounts.merge(arr[i], 1, (a, b) -> a + b);
        }

        for (Integer count : digitCounts.values()) {
            if (countSet.contains(count)) {
                return false;
            } else {
                countSet.add(count);
            }
        }

        return true;
    }
}
