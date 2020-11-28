package com.jemmy.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1365. 有多少小于当前数字的数字
 *
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/26
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Clarification: 对每个元素，统计数组中比它小的所有元素的数目
        // 方案1：暴力法 针对每个元素，整个列表搜索比较一遍
        // 时间复杂度: O(logN^2)
        // 空间复杂度: O(1)

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i]) {
                    res[i]++;
                }
            }
        }

        return res;
    }

    public int[] smallerNumbersThanCurrentTwo(int[] nums) {
        // 方案2：快速排序 对于排序后的数组中的每一个数，我们找出其左侧第一个小于它的数
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(N)

        // 二维数组，第一维表示数值，第二维表示位置
        int len = nums.length;
        int[][] arr  = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // 排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });

        // 找出左侧第一个小于它的数
        int[] res = new int[len];
        int pre = -1;
        for (int i = 0; i < len; i++) {
            // 如果相等，说明当前数字的个数已标识过
            if (pre == -1 || arr[i][0] != arr[i - 1][0]) {
                pre = i;
            }
            res[arr[i][1]] = pre;
        }

        return res;
    }

    public int[] smallerNumbersThanCurrentThree(int[] nums) {
        // 方案3：计数排序
        // 数组元素的值域范围为[0,100]，建立一个频次数组 frequent，frequent[i] 表示数字i出现的次数
        // 对于数字 i 而言，小于它的数目就为 frequent[0...i-1]的总和
        // 时间复杂度: O(N + K)
        // 空间复杂度: O(K) K 为长度101的数组

        int[] frequent = new int[101];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            frequent[nums[i]]++;
        }

        // 累加
        for (int i = 1; i <= 100; i++) {
            frequent[i] += frequent[i - 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i] == 0 ? 0 : frequent[nums[i] - 1];
        }

        return res;
    }
}
