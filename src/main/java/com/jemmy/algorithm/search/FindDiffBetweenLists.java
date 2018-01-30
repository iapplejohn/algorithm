/*
 * Copyright (C), 2014-2017, 杭州盎然科技有限公司
 * FileName: FindDiffBetweenLists.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/24 9:33
 * Description: 
 */
package com.jemmy.algorithm.search;

import java.util.*;

/**
 * 有List<String> list1和List<String> list2,两个集合各有上万个元素，怎样取出两个集合中不同的元素?
 *
 * @author Cheng Zhujiang
 * @date 2017/7/24
 */
public class FindDiffBetweenLists {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list1.add("test"+i);
            list2.add("test"+i*2);
        }
        List<String> diffs = getDifferent(list1,list2);
        System.out.println(diffs.size());
        List<String> theSames = getDifferent2(list1, list2);
        System.out.println(theSames.size());
        List<String> diffs3 = getDifferent3(list1, list2);
        System.out.println(diffs3.size());
        List<String> diffs4 = getDifferent4(list1, list2);
        System.out.println(diffs4.size());
//        List<String> diffs5 = getDifferent5(list1, list2);
//        System.out.println(diffs5.size());
        HashSet<String> diffs5 = getDifferent5(list1, list2);
        System.out.println(diffs5.size());
    }

    // 方法1：遍历两个集合：
    private static List<String> getDifferent(List<String> list1, List<String> list2) {
        long start = System.nanoTime();
        List<String> diffs = new ArrayList<>();
        for (String str : list1) {
            if (!list2.contains(str)) {
                diffs.add(str);
            }
        }

        for (String str : list2) {
            if (!list1.contains(str)) {
                diffs.add(str);
            }
        }

        System.out.println("getDiff1 total times " + (System.nanoTime() - start));
        return diffs;
    }

    // 方法2：采用List提供的retainAll（）方法：有问题：retainAll是保留相同的元素，不是不同的元素
    private static List<String> getDifferent2(List<String> list1, List<String> list2) {
        long start = System.nanoTime();
        List<String> theSames = new ArrayList<>();
        list1.retainAll(list2);

        for (String str : list2) {
            if (!list1.contains(str)) {
                theSames.add(str);
            }
        }

        System.out.println("getDiff2 total times " + (System.nanoTime() - start));
        return theSames;
    }

    // 通过Map方式
    private static List<String> getDifferent3(List<String> list1, List<String> list2) {
        long start = System.nanoTime();
        List<String> diffs = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>(list1.size() + list2.size());
        for (String str : list1) {
            map.put(str, 1);
        }

        for (String str : list2) {
            Integer count = map.get(str);
            if (count != null) {
                map.put(str, ++count);
            } else {
                map.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diffs.add(entry.getKey());
            }
        }

        System.out.println("getDiff3 total times " + (System.nanoTime() - start));
        return diffs;
    }

    // 通过Map方式优化
    private static List<String> getDifferent4(List<String> list1, List<String> list2) {
        long start = System.nanoTime();
        List<String> diffs = new ArrayList<>();

        List<String> maxList;
        List<String> minList;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        } else {
            maxList = list1;
            minList = list2;
        }

        Map<String, Integer> map = new HashMap<>(maxList.size());
        for (String str : maxList) {
            map.put(str, 1);
        }

        for (String str : minList) {
            Integer count = map.get(str);
            if (count != null) {
                map.put(str, ++count);
            } else {
                map.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diffs.add(entry.getKey());
            }
        }

        System.out.println("getDiff4 total times " + (System.nanoTime() - start));
        return diffs;
    }

    // 通过Map方式优化
    private static HashSet<String> getDifferent5(List<String> list1, List<String> list2) {
        long start = System.nanoTime();
        List<String> diffs = new ArrayList<>();

        List<String> maxList;
        List<String> minList;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        } else {
            maxList = list1;
            minList = list2;
        }

        Map<String, Integer> map = new HashMap<>(maxList.size());
        for (String str : maxList) {
            map.put(str, 1);
        }

        for (String str : minList) {
            Integer count = map.get(str);
            if (count == null) {
                diffs.add(str);
            } else {
                map.put(str, ++count);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diffs.add(entry.getKey());
            }
        }

        HashSet<String> distinctDiffs = getDistinctDiffs(diffs);
        System.out.println("getDiff5 total times " + (System.nanoTime() - start));
        return distinctDiffs;
    }

    private static HashSet<String> getDistinctDiffs(List<String> diffs) {
        return new HashSet<>(diffs);
    }
}
