package com.jemmy.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/6
 */
public class SortIntegersByTheNumberOf1Bits_1356 {

    public int[] sortByBits(int[] arr) {
        // Clarification: 根据二进制1的个数排序，如果相同，按数值大小排
        // 方案1：工具类排序，申明一个数组，位置为元素值，值为二进制1的个数，申请一个列表，将元素添加进去，并排序
        // 时间复杂度: O(NlogN) - 排序
        // 空间复杂度: O(N)

        int[] bits = new int[10001];
        List<Integer> list = new ArrayList<>(arr.length);
        for (int num : arr) {
            bits[num] = getBinaryOne(num);
            list.add(num);
        }

        list.sort((o1, o2) -> {
            if (bits[o1] == bits[o2]) {
                return o1 - o2;
            } else {
                return bits[o1] - bits[o2];
            }
        });

        int[] res = new int[arr.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private int getBinaryOne(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 2;
            num /= 2;
        }

        return count;
    }

    public int[] sortByBitsTwo(int[] arr) {
        // 方案2：和方案1类似，获取二进制1的个数做下改进：bits[i] = bits[i >> 1] + i & 1;

        List<Integer> list = new ArrayList<>(arr.length);
        for (int num : arr) {
            list.add(num);
        }

        int[] bits = new int[10001];
        for (int i = 0; i < 10001; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }

        list.sort((o1, o2) -> {
            if (bits[o1] == bits[o2]) {
                return o1 - o2;
            } else {
                return bits[o1] - bits[o2];
            }
        });

        int[] res = new int[arr.length];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }

        return res;
    }
}
