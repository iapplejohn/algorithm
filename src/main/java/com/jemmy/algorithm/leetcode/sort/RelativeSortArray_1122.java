package com.jemmy.algorithm.leetcode.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/14
 */
public class RelativeSortArray_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Clarification：arr2 元素各不相同，都出现在 arr1中，对 arr1 中的元素排序，相对顺序和 arr2 相同，其他按升序放在 arr1 的末尾
        // 方案1：计数排序，使用 LinkedHashMap 记录元素出现次数（保持相对顺序），剩余的放到 优先队列中排序，再输出
        // 时间复杂度: O(NlogN)
        // 空间复杂度: O(N)

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr2) {
            map.put(num, 0);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 记录 arr1 中 arr2 元素出现的次数
        for (int num : arr1) {
            Integer count = map.get(num);
            if (count != null) {
                map.put(num, count + 1);
            } else {
                // 其他的放到优先队列中进行排序
                queue.add(num);
            }
        }

        int[] res = new int[arr1.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            while (count-- > 0) {
                res[i++] = entry.getKey();
            }
        }

        // 输出未出现的元素
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }

        return res;
    }

    public int[] relativeSortArrayTwo(int[] arr1, int[] arr2) {
        // 方案2：计数排序，使用数组
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        // 数值范围: 0-1000，位置和元素一致，值为 arr1 元素出现的次数
        int[] arr = new int[1001];
        for (int num : arr1) {
            arr[num]++;
        }

        // 按照 arr2 元素的顺序，输出数字
        int[] res = new int[arr1.length];
        int i = 0;
        for (int num2 : arr2) {
            while (arr[num2] > 0) {
                res[i++] = num2;
                arr[num2]--;
            }
        }

        // 输出未出现的元素
        for (int j = 0; j < arr.length; j++) {
            while (arr[j] > 0) {
                res[i++] = j;
                arr[j]--;
            }
        }

        return res;
    }

    public int[] relativeSortArrayThree(int[] arr1, int[] arr2) {
        // 方案3：lambda 排序，使用自定义比较函数
        // 时间复杂度: O(n)
        // 空间复杂度: O(nlogn)

        // 使用 map 存储 arr2 出现的元素 和 对应的位置，方便后续比较
        int capacity = (int) (arr2.length / 0.75);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(capacity);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // 数组先转成列表，Arrays.sort 不太好支持自定义比较器
        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        Collections.sort(res, (o1, o2) -> {
            // 如果其中有一个数在 arr2 中，按照 arr2 的顺序来计算，不在的数按照 1001
            if (map.containsKey(o1) || map.containsKey(o2)) {
                return map.getOrDefault(o1, 1001) - map.getOrDefault(o2, 1001);
            } else {
                // 如果两个都不在 arr 2 中，按照数字大小
                return o1 - o2;
            }
        });

        return res.stream().mapToInt(num  -> num).toArray();
    }
}
