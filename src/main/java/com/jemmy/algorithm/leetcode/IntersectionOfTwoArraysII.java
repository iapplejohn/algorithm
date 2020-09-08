package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 *
 *  1. 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *  2. 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 *
 *  1. 如果给定的数组已经排好序呢？你将如何优化你的算法？
 *      - 排序双指针
 *  2. 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *      - 将较小的数组哈希计数，随后在另一个数组中根据哈希来寻找。
 *  3. 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *      - 通过归并外排将两个数组排序后再使用排序双指针查找
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/6/29
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 审题: 两个无序数组，求交集，元素出现次数需一致（可能有重复元素）
        // 方案1: 暴力 双重循环，对每个nums1的元素，遍历nums2是否有相同，有则看下个nums1元素
        // 使用map来存储符合条件的nums2元素位置和值
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)
        if ((nums1 == null || nums1.length == 0)
            || (nums2 == null || nums2.length == 0)) {
            return new int[0];
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!map.containsKey(j) && nums1[i] == nums2[j]) {
                    map.put(j, nums2[j]);
                    break;
                }
            }
        }

        int[] array = new int[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[k++] = entry.getValue();
        }

        return array;
    }

    public int[] intersectTwo(int[] nums1, int[] nums2) {
        // 方案2: 哈希，将nums1的值和出现次数存到map中，然后遍历nums2，判断是否存在，存在则
        // map中的出现次数减一
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if ((nums1 == null || nums1.length == 0)
            || (nums2 == null || nums2.length == 0)) {
            return new int[0];
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            if (value != null) {
                map.put(nums1[i], value + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        Map<Integer, Integer> matchMap = new LinkedHashMap<>();
        for (int j = 0; j < nums2.length; j++) {
            Integer value = map.get(nums2[j]);
            if (value != null && !matchMap.containsKey(j)) {
                matchMap.put(j, nums2[j]);
                if (value == 1) {
                    map.remove(nums2[j]);
                } else {
                    map.put(nums2[j], value - 1);
                }
            }
        }

        int[] array = new int[matchMap.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : matchMap.entrySet()) {
            array[k++] = entry.getValue();
        }

        return array;
    }

    public int[] intersectTwoBrief(int[] nums1, int[] nums2) {
        // 方案2: 哈希，将nums1的值和出现次数存到map中，然后遍历nums2，判断是否存在，存在则
        // map中的出现次数减一
        // 时间复杂度: O(n + m)
        // 空间复杂度: O(min(n, m))

        if (nums1.length > nums2.length) {
            return intersectTwoBrief(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int k = 0;
        for (int n : nums2) {
            int value = map.getOrDefault(n, 0);
            if (value > 0) {
                nums1[k++] = n;
                map.put(n, value - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersectThree(int[] nums1, int[] nums2) {
        // 方案3: 排序，然后通过双指针，比较两个数组元素的大小，小的指针自增，相等则放到nums1的起始位置
        // 时间复杂度: O(n log(n) + m log(m))
        // 空间复杂度: O(1)

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }


    public int[] intersectFour(int[] nums1, int[] nums2) {
        // 方案4: 语言提供的方法, 如java里的retainAll
        // 时间复杂度: O(n * m) retainAll方法里面有双重循环
        // 空间复杂度: O(n + m)

        List<Integer> list1 = new ArrayList<>(nums1.length);
        for (int num : nums1) {
            list1.add(num);
        }

        List<Integer> list2 = new ArrayList<>(nums2.length);
        for (int num : nums2) {
            list2.add(num);
        }

        // 方法不满足要求，会保留重复值
        // 输入[1, 2, 2, 1]和[2]
        // 输出[2, 2]
        // 期望[2]
        list1.retainAll(list2);

        int[] result = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            result[i] = list1.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII instance = new IntersectionOfTwoArraysII();
        int[] result = instance.intersectFour(new int[]{1, 2, 2, 1}, new int[]{2});
        System.out.println("result = " + Arrays.toString(result));
    }
}
