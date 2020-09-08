package com.jemmy.algorithm.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhujiang.cheng
 * @since 2020/7/15
 */
public class CongShangDaoXiaDaYinErChaShuIILcof {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Clarification: 层序遍历
        // 方案1：BFS，利用队列来保存下一轮（层）遍历的节点

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        // 循环一次，处理某一层的所有节点，如果判断是同一层？通过队列的大小来确定
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                // 下面操作，队列大小发生改变，但不影响上一层（size）的遍历
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(list);
        }

        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        // 方案2: DFS，需要清楚当前节点所在的层（通过level遍历处理），将值放到列表指定位置

        if (root == null) {
            return res;
        }

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        // terminator
        if (node == null) {
            return;
        }

        // process current
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        // 下面代码会报索引越界异常
        // List<Integer> list = res.get(level);

        // drill down
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }

        // reverse current
    }
}
