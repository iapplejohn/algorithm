package com.jemmy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhujiang.cheng
 * @since 2020/7/1
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        // 审题: 从1到n，3、5或15的倍数输出特殊字符串，其他输出数字
        // 方案1: 模拟法，取余判断是否3、5或15的倍数
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    public List<String> fizzBuzzTwo(int n) {
        // 方案2: 字符串连接，3倍数的字符串，连上5倍数的字符串
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();

            if (i % 3 == 0) {
                builder.append("Fizz");
            }

            if (i % 5 == 0) {
                builder.append("Buzz");
            }

            if (builder.length() == 0) {
                builder.append(i);
            }

            result.add(builder.toString());
        }

        return result;
    }

    public List<String> fizzBuzzTwoPlus(int n) {
        // 方案2: 字符串连接，3倍数的字符串，连上5倍数的字符串
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            // 字符串连接多次，会创建多个StringBuilder
            String str = "";

            if (i % 3 == 0) {
                str += "Fizz";
            }

            if (i % 5 == 0) {
                str += "Buzz";
            }

            if (str.length() == 0) {
                str = Integer.toString(i);
            }

            result.add(str);
        }

        return result;
    }

    public List<String> fizzBuzzThree(int n) {
        // 方案3: 哈希法
        List<String> result = new ArrayList<>(n);

        Map<Integer, String> map = new LinkedHashMap<Integer, String>(4) {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (i % entry.getKey() == 0) {
                    builder.append(entry.getValue());
                }
            }

            if (builder.length() == 0) {
                result.add(Integer.toString(i));
            } else {
                result.add(builder.toString());
            }
        }

        return result;
    }
}
