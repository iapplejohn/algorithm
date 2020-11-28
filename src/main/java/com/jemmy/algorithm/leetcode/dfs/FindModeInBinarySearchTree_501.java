package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值 结点右子树中所含结点的值大于等于当前结点的值 左子树和右子树都是二叉搜索树 例如： 给定 BST [1,null,2,2],
 *
 * 1 \ 2 / 2 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 *
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/24
 */
public class FindModeInBinarySearchTree_501 {

    int frequentCount = 0;
    List<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        // Clarification: 有相同值的二叉搜索树，找出所有出现频率最高的元素
        // 方案1：遍历 + 哈希
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        if (root == null) {
            return new int[]{};
        }

        // 遍历
        dfs(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        int value = node.val;
        int count = map.getOrDefault(value, 0);
        count++;
        map.put(value, count);
        if (count > frequentCount) {
            frequentCount = count;
            list.clear();
            list.add(value);
        } else if (count == frequentCount) {
            list.add(value);
        }

        // drill down
        dfs(node.left);
        dfs(node.right);

        // reverse current states
    }

    // 方案2：中序遍历
}
