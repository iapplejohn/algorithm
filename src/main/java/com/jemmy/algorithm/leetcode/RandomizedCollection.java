package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/31
 */
public class RandomizedCollection {

    // Clarification: 增删查时间复杂度O(1)，查询随机返回，概率一样
    // 方案1：Map + ArrayList
    // ArrayList: 实现随机读，O(1)删除(最后的元素和i交换，然后删除最后元素），如何O(1)找到元素，使用Map记录位置，
    // 允许重复，使用Set记录位置集合，判断元素是否存在，使用Map

    /**
     * 数字-列表存储位置集合
     */
    private Map<Integer, Set<Integer>> map;

    /**
     * 数字列表
     */
    private ArrayList<Integer> list;

    private Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        list.add(val);
        set.add(list.size() - 1);
        map.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> set = map.get(val);
        Iterator<Integer> iterator = set.iterator();
        Integer pos = iterator.next();
        iterator.remove();

        Integer last = list.get(list.size() - 1);
        list.set(pos, last);

        if (pos < list.size() - 1) {
            map.get(last).add(pos);
        }
        if (!iterator.hasNext()) {
            map.remove(val);
        }
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomPos = random.nextInt(list.size());
        return list.get(randomPos);
    }

}
