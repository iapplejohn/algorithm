package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * @since 2020/10/5
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 从数组中找出所有不重复的四元组，其值为 target
        // 方案1: 排序 + 双指针
        // 第1,2个数双重循环，第3,4个元素双指针

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        // 4个指针
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            // 处理重复数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 剪枝: 当前最小和超过目标值
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 剪枝: 当前最大和小于目标值
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                // 处理重复数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1, l = len - 1;
                // 剪枝: 当前最小值超过目标值
                if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                    continue;
                }

                // 剪枝: 当前最大值小于目标值
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
                        List<Integer> matched = new ArrayList<>();
                        matched.add(nums[i]);
                        matched.add(nums[j]);
                        matched.add(nums[k]);
                        matched.add(nums[l]);
                        res.add(matched);
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

        return res;
    }
        // 方案1: 四重循环
}
