package com.jemmy.algorithm.everyday;

import java.util.Arrays;
import java.util.HashSet;
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
 * @since 2020/7/8
 */
public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        // Clarification: 两个无序数组，求交集，输出的元素是唯一的，不考虑顺序
        // 方案1：两个for循环，输出的数组通过Set去重
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n)

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }

        int j = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[j++] = num;
        }

        return result;
    }

    public int[] intersectionTwo(int[] nums1, int[] nums2) {
        // 方案2：通过Set记录第一个数组，遍历第二个数组的每个元素，是否在set中
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        Set<Integer> sameSet = new HashSet<>();
        for (Integer num : nums2) {
            if (set.contains(num)) {
                sameSet.add(num);
            }
        }

        int j = 0;
        int[] result = new int[sameSet.size()];
        for (Integer num : sameSet) {
            result[j++] = num;
        }

        return result;
    }

    public int[] intersectionThree(int[] nums1, int[] nums2) {
        // 方案3：双set

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            set2.add(nums2[j]);
        }

        if (set1.size() < set2.size()) {
            return intersection_set(set1, set2);
        } else {
            return intersection_set(set2, set1);
        }
    }

    private int[] intersection_set(Set<Integer> set1, Set<Integer> set2) {
        int[] output = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            if (set2.contains(num)) {
                output[i++] = num;
            }
        }

        return Arrays.copyOf(output, i);
    }

    public int[] intersectionFour(int[] nums1, int[] nums2) {
        // 方案4：内置函数

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            set2.add(nums2[j]);
        }

        set1.retainAll(set2);
        int[] output = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            output[i++] = num;
        }

        return output;
    }

    public int[] intersectionFive(int[] nums1, int[] nums2) {
        // 方案5：排序 + 双指针 : 超出时间限制
        // 时间复杂度：O(nlogn)
        // 空间复杂度：O(n)

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] output = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            output[k++] = num;
        }

        return output;
    }
}
