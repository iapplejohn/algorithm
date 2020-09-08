package com.jemmy.algorithm.leetcode;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3] 输出: 10
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 *
 * @author zhujiang.cheng
 * @since 2020/6/24
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        // 暴力1：三重循环，求出最大值,超时
        // for i -> 0, n - 2
        //    for j -> i + 1, n - 1
        //        (i - j) -> 最小高度, area
        //        update max-area

        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int min = heights[i];
                for (int k = i + 1; k <= j; k++) {
                    if (heights[k] < min) {
                        min = heights[k];
                    }
                }
                int area = (j - i + 1) * min;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public int largestRectangleArea_2(int[] heights) {
        // 暴力2: 遍历每个高度，获取左右边界
        // for i -> 0, n - 1
        //    找到 left bound, right bound,
        //    area = heights[i] * (right - left)
        //    update max-area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= heights[i]) {
                right++;
            }
            int area = (right - left + 1) * heights[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        System.out.println(instance.largestRectangleArea(heights));
    }

}
