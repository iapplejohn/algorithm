package com.jemmy.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/2
 */
public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        // Clarification: 两个数组的交集
        // 方案1：暴力法，双重循环
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            res[k++] = next;
        }

        return res;
    }

    public int[] intersectionTwo(int[] nums1, int[] nums2) {
        // 方案2：哈希法
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        Set<Integer> distinct = new HashSet<>();
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                distinct.add(nums2[j]);
            }
        }

        int[] res = new int[distinct.size()];
        int k = 0;
        for (Iterator<Integer> iterator = distinct.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            res[k++] = next;
        }

        return res;
    }

    public int[] intersectionThree(int[] nums1, int[] nums2) {
        // 方案3：双哈希表

        Set<Integer> set1 = new HashSet<>();
        for (int num1: nums1) {
            set1.add(num1);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num2 : nums2) {
            set2.add(num2);
        }

        if (set1.size() < set2.size()) {
            return intersectionSet(set1, set2);
        } else {
            return intersectionSet(set2, set1);
        }
    }

    private int[] intersectionSet(Set<Integer> set1, Set<Integer> set2) {
        int[] output = new int[set1.size()];
        int i = 0;

        for (Integer num1 : set1) {
            if (set2.contains(num1)) {
                output[i++] = num1;
            }
        }

        return Arrays.copyOf(output, i);
    }

    public int[] intersectionFour(int[] nums1, int[] nums2) {
        // 方案4：利用内置函数 retainAll

        Set<Integer> set1 = new HashSet<>((int) (nums1.length / 0.75));
        for (Integer num1 : nums1) {
            set1.add(num1);
        }

        Set<Integer> set2 = new HashSet<>((int) (nums2.length / 0.75));
        for (Integer num2 : nums2) {
            set2.add(num2);
        }

        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            res[i++] = num;
        }

        return res;
    }

    public int[] intersectionFive(int[] nums1, int[] nums2) {
        // 方案5：排序 + 双指针
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(n)

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                // i和j都要自增，否则超出时间限制
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }

        return res;
    }
}
