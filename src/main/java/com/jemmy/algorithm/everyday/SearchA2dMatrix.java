package com.jemmy.algorithm.everyday;

/**
 * 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/3
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Clarification: 二维矩阵有序，查找目标值
        // 方案1：暴力
        // 时间复杂度：O(mn)
        // 空间复杂度：O(1)
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchMatrixTwo(int[][] matrix, int target) {
        // 方案2：二分查找
        // 垂直二分 + 水平二分
        // 时间复杂度: O(logn)
        // 空间复杂度: O(1)

        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        // 垂直方向进行二分查找
        int top = 0, bottom = rows - 1, row = -1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][cols - 1] < target) {
                top = mid + 1;
            } else {
                row = mid;
                break;
            }
        }

        // 水平方向进行二分查找
        if (row >= 0) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    public boolean searchMatrixThree(int[][] matrix, int target) {
        // 方案3: 转为一维矩阵进行二分查找 TODO

        return false;
    }
}
