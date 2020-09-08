package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhujiang.cheng
 * @since 2020/6/26
 */
public class Find3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        // 方案1: 暴力

        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // 三重循环
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] array = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(array);
                        List<Integer> list = new ArrayList<>(3);
                        list.add(array[0]);
                        list.add(array[1]);
                        list.add(array[2]);
                        String key = array[0] + "_" + array[1] + "_" + array[2];
                        if (!set.contains(key)) {
                            result.add(list);
                            set.add(key);
                        }
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum_2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        // 方案2: a + b + c = 0 转为 a + b = -c
        // 先遍历数组，将值乘以-1存到map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < nums.length; k++) {
            map.put(-nums[k], k);
        }

        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // 双重循环，判断a + b的值，是否存在于map中
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)) {
                    int k = map.get(sum);
                    if (i != k && j != k) {
                        int[] array = new int[]{nums[i], nums[j], -sum};
                        Arrays.sort(array);
                        List<Integer> list = new ArrayList<>(3);
                        list.add(array[0]);
                        list.add(array[1]);
                        list.add(array[2]);
                        String key = array[0] + "_" + array[1] + "_" + array[2];
                        if (!set.contains(key)) {
                            result.add(list);
                            set.add(key);
                        }
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum_3(int[] nums) {
        // 方案3: 排序 + 双指针夹逼
        // 排序
        Arrays.sort(nums);

        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // 双重循环，判断a + b的值，是否存在于map中

        return result;
    }

    public static void main(String[] args) {
        Find3Sum instance = new Find3Sum();
        List<List<Integer>> result = instance.threeSum(new int[] {-1,0,1,2,-1,-4});
        System.out.println("result = " + result);
    }

}
