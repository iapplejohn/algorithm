package com.jemmy.algorithm.leetcode.top;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/25
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        // Clarification: 找出只出现一次的数字，其他出现2次
        // 方案1: 哈希表，如果不存在放入，存在则删除，最后存在哈希表中，即为只出现一次的元素

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.iterator().next();
    }

    // 方案2: 暴力 两层循环
    // 方案3: 快排

    public int singleNumberFour(int[] nums) {
        // 方案4: 位运算 异或
        int res = nums[0];

        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }

}
