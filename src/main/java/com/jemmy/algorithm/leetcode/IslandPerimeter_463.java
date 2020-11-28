package com.jemmy.algorithm.leetcode;

/**
 * 463. 岛屿的周长
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/30
 */
public class IslandPerimeter_463 {

    public int islandPerimeter(int[][] grid) {
        // Clarification：只有一个岛屿，求周长
        // 方案1：一次遍历，如果是岛屿，上下左右格子：如果到了边界，边长加1，如果是水，边长加1

        int res = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // 左
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    // 上
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    // 右
                    if (j == cols - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                    // 下
                    if (i == rows - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public int islandPerimeterTwo(int[][] grid) {
        // 方案2：DFS，找到岛屿的格子后，分别对四周进行判断

        int res = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, i, j, rows, cols);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int r, int c, int rows, int cols) {
        // terminator
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == 2) {
            return 0;
        }

        // process current logic
        grid[r][c] = 2;

        // drill down
        int ret = 0;
        ret += dfs(grid, r, c - 1, rows, cols);
        ret += dfs(grid, r -  1, c, rows, cols);
        ret += dfs(grid, r, c + 1, rows, cols);
        ret += dfs(grid, r + 1, c, rows, cols);

        // reverse current states

        return ret;
    }
}
