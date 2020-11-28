package com.jemmy.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. 根据身高重建队列
 *
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author zhujiang.cheng
 * @since 2020/11/16
 */
public class QueueReconstructionByHeight_406 {

    public int[][] reconstructQueue(int[][] people) {
        // Clarification: 顺序打乱的一群人站成一个队列，每个人(h, k)，h为身高，k为前面大于等于h的人数，重建队列
        // 方案1：先排序后插入
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(nlogn)

        // 先根据身高升序排，身高相同时，根据 k 降序排
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int n = people.length;
        int[][] res = new int[n][];

        // 针对每个人，找到放置的位置
        for (int[] person : people) {
            // 位置 = 前面 k 个空间（身高大于等于）+ 1（自己）
            int spaces = person[1] + 1;

            // 如果有空位置，spaces 减一，直到等于0，代表放入位置
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    spaces--;

                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }

        return res;
    }
}
