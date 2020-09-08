package com.jemmy.algorithm.everyday;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/9
 */
public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {
        // Clarification: n > 0，生成正方形矩阵，元素按顺时针递增排列
        // 按顺序输出: 从1开始填，一直到n^2，
        // 4个指针-位置下标
        // 指针往中心移动：
        //       上指针
        //         |
        //         V
        // 左指针 -> <- 右指针
        //         ^
        //         |
        //       下指针

        int[][] result;
        if (n == 1) {
            result = new int[1][1];
            result[0][0] = 1;
            return result;
        }

        result = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1, target = n * n;
        while (num <= target) {
            // left -> right
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            // right -> left
            for (int i = right; i >= left; i--) {
                result[bottom][i] = num++;
            }
            bottom--;

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                result[i][left] = num++;
            }
            left++;
        }

        return result;
    }

}
