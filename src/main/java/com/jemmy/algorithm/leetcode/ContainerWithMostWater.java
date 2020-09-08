package com.jemmy.algorithm.leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author zhujiang.cheng
 * @since 2020/6/15
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // 方案1：两个for循环
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length -1; j > i; j--) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                if (temp > maxArea) {
                    maxArea = temp;
                }
            }
        }

        return maxArea;
    }

    public int maxArea_2(int[] height) {
        // 方案2：双指针
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

}
