package com.jemmy.algorithm.leetcode.string;

/**
 * 514. 自由之路
 *
 * 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 *
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 *
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 *
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 示例：
 *
 *  
 *
 *
 *  
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 *  对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 *  对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 *  当然, 我们还需要1步进行拼写。
 *  因此最终的输出是 4。
 * 提示：
 *
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/freedom-trail
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/11
 */
public class FreedomTrail_514 {

    public int findRotateSteps(String ring, String key) {
        // Clarification: 拼成key字符，需要顺逆时针旋转ring，使对准12点的字符刚好是key[i]（每转一格为1步），然后按中心按钮（1步），求最少步数
        // 方案1：模拟法 两个指针：当前12点指向字符的位置，key当前的位置

        int j = 0, steps = 0, len = ring.length();
        for (int i = 0; i < key.length(); i++) {
            char target = key.charAt(i);

            int left = j, right = j;
            while (ring.charAt(left) !=  target && ring.charAt(right) != target) {
                left = (j + len - 1) % len;
                right = (j + 1) % len;
                steps++;

                if (ring.charAt(left) == target) {
                    j = left;
                    break;
                }

                if (ring.charAt(right) == target) {
                    j = right;
                    break;
                }
            }

            steps++;
        }

        return steps;
    }

}
