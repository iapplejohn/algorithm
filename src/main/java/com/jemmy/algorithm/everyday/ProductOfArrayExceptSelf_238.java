package com.jemmy.algorithm.everyday;

/**
 * 238. 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/8/30
 */
public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        // Clarification: 数组长度大于1，不要使用除法，O(n)时间复杂度
        // 方案1: 左右乘积列表
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        int len = nums.length;

        // 左侧乘积列表
        int[] l = new int[len];
        // 右侧乘积列表
        int[] r = new int[len];

        // 结果列表
        int[] res = new int[len];

        // 计算左侧乘积
        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        // 计算右侧乘积
        r[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            r[j] = nums[j + 1] * r[j + 1];
        }

        // 计算乘积: 左侧乘积 * 右侧乘积
        for (int k = 0; k < len; k++) {
            res[k] = l[k] * r[k];
        }

        return res;
    }

    public int[] productExceptSelfTwo(int[] nums) {
        // 方案2: 空间复杂度降为1
        // 使用输出数组，构建左侧乘积列表，然后动态构建右侧乘积，初始值为1，用一个变量表示
        // 时间复杂度: O(n)
        // 空间复杂度: O(1)

        int len = nums.length;

        // 输出数组，不算在空间复杂度内
        int[] res = new int[len];

        // 先作为左侧乘积数组使用
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int r = 1;
        // 计算乘积：左侧乘积 * 右侧乘积，同时动态构建右侧乘积，所以要从右向左遍历
        for (int k = len - 1; k >= 0; k--) {
            res[k] = res[k] * r;
            r *= nums[k];
        }

        return res;
    }

}
