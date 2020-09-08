package com.jemmy.algorithm.everyday;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/6
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Clarification: 从整数数组找4个元素，其和等于target，四元组不能重复
        // 常规: 4个for循环

        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            int[] array = new int[] {nums[i], nums[j], nums[k], nums[l]};
                            Arrays.sort(array);
                            String key = array[0] + "_" + array[1] + "_" + array[2] + "_" + array[3];
                            if (!set.contains(key)) {
                                List<Integer> matched = new ArrayList<>(4);
                                matched.add(array[0]);
                                matched.add(array[1]);
                                matched.add(array[2]);
                                matched.add(array[3]);
                                list.add(matched);
                                set.add(key);
                            }
                        }
                    }
                }
            }
        }

        return list;
    }

    public List<List<Integer>> fourSumTwo(int[] nums, int target) {
        // 排序 + 四指针
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }

        // 排序
        Arrays.sort(nums);

        // 4个指针: i, j, k, l
        // i 从 0 开始，j 从 i+1 开始，k 从 j + 1 开始，l 从 数组尾部开始
        // i和j两个for循环，k和l往中间夹逼
        // 注意处理重复数字问题
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            // 处理重复数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 当前最小值：从i开始，连续的4个数之和大于目标值，后面的值更大不满足条件
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 当前最大值：i和最后3个数之和小于目标值，之间的值更不满足条件，当前i不需检查，看下个i
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                // 处理重复数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1, l = len - 1;
                // 当前最小值
                if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                    continue;
                }

                // 当前最大值
                if (nums[i] + nums[j] + nums[l - 1] + nums[l] < target) {
                    continue;
                }

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> matched = new ArrayList<>(4);
                        matched.add(nums[i]);
                        matched.add(nums[j]);
                        matched.add(nums[k]);
                        matched.add(nums[l]);
                        list.add(matched);
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return list;
    }
}
