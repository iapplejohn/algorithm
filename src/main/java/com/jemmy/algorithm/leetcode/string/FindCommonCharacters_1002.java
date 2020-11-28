package com.jemmy.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/14
 */
public class FindCommonCharacters_1002 {

    public List<String> commonChars(String[] A) {
        // Clarification: 返回在所有字符串都出现的字符列表（包括重复字符）
        // 方案1: 长度为26的整型数组，记录字符出现的次数，另一个长度为26的整型数组，存储字符出现的最少次数（需要比较）

        int[] minFreqArr = new int[26];
        Arrays.fill(minFreqArr, -1);

        for (String str : A) {
            int[] freqArr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                freqArr[ch - 'a']++;
            }

            // 和之前的最少次数进行比较
            for (int j = 0; j < minFreqArr.length; j++) {
                if (minFreqArr[j] == -1) {
                    minFreqArr[j] = freqArr[j];
                } else {
                    minFreqArr[j] = Math.min(minFreqArr[j], freqArr[j]);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int k = 0; k < minFreqArr.length; k++) {
            if (minFreqArr[k] > 0) {
                char ch = (char) (k + 'a');
                String s = String.valueOf(ch);
                while (--minFreqArr[k] >= 0) {
                    res.add(s);
                }
            }
        }

        return res;
    }

        // 方案2: 哈希表
}
