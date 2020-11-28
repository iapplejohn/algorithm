package com.jemmy.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1 输出：[[-2,2]] 解释： (1, 3) 和原点之间的距离为 sqrt(10)， (-2, 2) 和原点之间的距离为 sqrt(8)， 由于 sqrt(8) <
 * sqrt(10)，(-2, 2) 离原点更近。 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2 输出：[[3,3],[-2,4]] （答案 [[-2,4],[3,3]] 也会被接受。）  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000 -10000 < points[i][0] < 10000 -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/9
 */
public class KClosestPointsToOrigin_973 {

    public int[][] kClosest(int[][] points, int K) {
        // Clarification: 求最接近原点的 k 个点
        // 方案1：排序，取前 K 个点
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(N)

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[0] + o1[1] * o1[1] - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });

        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosestTwo(int[][] points, int K) {
        // 方案2：求出每个点坐标的平方和，放到小顶堆中
        // 时间复杂度: O(NlogK)
        // 空间复杂度: O(N)

        // 默认小顶堆，使用 Comparator 改成大顶堆，这样 poll() 就能删除较大元素
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < K; i++) {
            int square = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            queue.offer(new int[]{square, i});
        }

        for (int i = K; i < points.length; i++) {
            int square = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (square < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{square, i});
            }
        }

        int[][] res = new int[K][2];
        int j = 0;
        while (!queue.isEmpty()) {
            int[] squarePos = queue.poll();
            res[j++] = points[squarePos[1]];
        }

        return res;
    }

    public int[][] kClosestThree(int[][] points, int K) {
        // TODO 方案3：快速选择（快速排序的思想）
        return null;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin_973 instance = new KClosestPointsToOrigin_973();
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] res = instance.kClosest(points, 1);
        System.out.println("res = " + res);
    }
}
