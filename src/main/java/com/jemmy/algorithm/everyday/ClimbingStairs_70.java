package com.jemmy.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/21
 */
public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        // 方案1：递归 + 缓存

        if (n <= 3) {
            return n;
        }

        int capacity = (int) (n / 0.75);
        Map<Integer, Integer> cacheMap = new HashMap<>(capacity);

        return recursive(n, cacheMap);
    }

    private int recursive(int n, Map<Integer, Integer> cacheMap) {
        // terminator
        if (n <= 3) {
            return n;
        }

        // process current
        if (cacheMap.containsKey(n)) {
            return cacheMap.get(n);
        }

        // drill down
        int count = recursive(n - 2, cacheMap) + recursive(n - 1, cacheMap);
        cacheMap.put(n, count);

        // reverse current

        return count;
    }

    public int climbStairsTwo(int n) {
        // 方案2：迭代
        // 三个连续的位置，爬楼梯的方案数，从最初位置开始，一直往后迭代
        if (n <= 3) {
            return n;
        }

        int c1 = 1, c2 = 2, c3 = 3, p = 3;
        while (p <= n) {
            c3 = c1 + c2;
            c1 = c2;
            c2 = c3;
            p++;
        }

        return c3;
    }

}
