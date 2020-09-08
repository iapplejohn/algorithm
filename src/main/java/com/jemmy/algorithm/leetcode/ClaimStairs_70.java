package com.jemmy.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
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
 *
 * @author zhujiang.cheng
 * @since 2020/6/26
 */
public class ClaimStairs_70 {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        // 方案1：递归 + 缓存
        // 自顶向下: 走到n级台阶走法 = 走到n - 2级台阶走法，跨两步 + 走到n - 1级台阶走法，跨一步

        // terminator
        if (n <= 2) {
            return n;
        }

        // process current loop
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // drill down to next loop
        int value = climbStairs(n - 2) + climbStairs(n - 1);
        cache.put(n, value);

        return value;
        // clean the cache
    }

    public int climbStairs_2(int n) {
        // 方案2：循环
        // 自底向上: 保留最近三个台阶的走法，依次往前推进

        // terminator
        if (n <= 2) {
            return n;
        }

        int c1 = 1, c2 = 2, c3 = 3;
        for (int i = 4; i <= n; i++) {
            c3 = c1 + c2;
            c1 = c2;
            c2 = c3;
        }

        return c3;
    }

}
