package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/10/15
 */
public class PopulatingNextRightPointersInEachNode_116 {

    public Node connect(Node root) {
        // Clarification: 完美二叉树，填充每个节点的右侧节点指针
        // 方案1: 层序遍历 使用队列辅助，使用 prev 指向该层上一个节点

        if (root == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (prev != null) {
                    prev.next = node;
                }

                prev = node;
            }
        }

        return root;
    }

    private List<List<Node>> nodes = new ArrayList<>();

    public Node connectTwo(Node root) {
        // 方案2: dfs
        // 递归参数: 当前节点，递归层级

        if (root == null) {
            return null;
        }

        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int level) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        if (level >= nodes.size()) {
            nodes.add(new ArrayList<>());
        }
        List<Node> list = nodes.get(level);
        int size = list.size();
        if (size > 0) {
            list.get(size - 1).next = node;
        }
        list.add(node);

        // drill down
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }

        // reverse current states
    }

    public Node connectThree(Node root) {
        // 方案3: 使用已建立的 next 指针 TODO

        return null;
    }
}
