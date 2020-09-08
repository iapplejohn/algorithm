package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/21
 */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        // Clarification: 满足三数之和等于0，且不重复
        // 方案1: 暴力 三重循环 超出时间限制
        // 时间复杂度: O(n^3)
        // 空间复杂度: O(n)

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] arr = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(arr);
                        String key = arr[0] + "_" + arr[1] + "_" + arr[2];
                        if (!set.contains(key)) {
                            set.add(key);
                            res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                        }
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSumTwo(int[] nums) {
        // 方案2: 哈希映射，a + b = -c
        // 将 -c 作为key，位置作为 value 存到哈希表中，两重循环：第一个数和第二个数，和是否存在哈希表中，且不是同一个位置的数
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        int capacity = (int) (nums.length / 0.75);
        Map<Integer, Integer> map = new HashMap<>(capacity);
        for (int k = 0; k < nums.length; k++) {
            map.put(-nums[k], k);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                Integer k = map.get(sum);
                if (k != null && k != i && k != j) {
                    int[] arr = new int[]{nums[i], nums[j], nums[k]};
                    Arrays.sort(arr);
                    String key = arr[0] + "_" + arr[1] + "_" + arr[2];
                    if (!set.contains(key)) {
                        set.add(key);
                        res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSumThree(int[] nums) {
        // 方案3: 排序，二分查找
        // 排序后，遍历每个位置 i
        // 如果nums[i] 大于0，后面不会找到加起来等于0的元素，返回
        // 令 l = i + 1, r = len - 1，判断三者和：
        // 等于0，添加到返回列表中，寻找下一个解
        // 大于0，说明 r 太大，左移
        // 小于0，说明 l 太小，右移

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }

            // 去除重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    String key = nums[i] + "_" + nums[l] + "_" + nums[r];
                    if (!set.contains(key)) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        set.add(key);
                    }
                    if (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    if (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}
