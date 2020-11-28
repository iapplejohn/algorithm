package com.jemmy.algorithm.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * 给定一个二叉树
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
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/28
 */
public class PopulatingNextRightPointersInEachNodeII_117 {

    public Node connect(Node root) {
        // Clarification: 填充节点的 next 指针
        // 方案1: bfs 使用队列辅助 类似层序遍历

        if (root == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }

        return root;
    }

    List<List<Node>> list = new ArrayList<>();

    public Node connectTwo(Node root) {
        // 方案2: dfs 使用递归
        // 递归参数: 当前节点，当前层级，列表
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int level) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        List<Node> nodes = list.get(level);
        if (nodes.size() > 0) {
            nodes.get(nodes.size() - 1).next = node;
        }
        nodes.add(node);

        // drill down
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }

        // reverse current states
    }

    Node prev = null, nextStart = null;
    public Node connectThree(Node root) {
        // 方案3: 使用已建立的 next 指针
        // 建立下一层的next 指针，然后移到下一层遍历，根据 left 和 right 指针，建立下下层的 next 指针

        if (root == null) {
            return null;
        }

        Node start = root;
        // 循环每一层
        while (start != null) {
            // 下一层前一个节点
            prev = null;
            // 下一层开始节点
            nextStart = null;

            // 遍历当前层（已由上一次的循环构建 next 链）
            for (Node n = start; n != null; n = n.next) {
                if (n.left != null) {
                    handle(n.left);
                }
                if (n.right != null) {
                    handle(n.right);
                }
            }

            // 移到下一层
            start = nextStart;
        }

        return root;
    }

    private void handle(Node node) {
        if (prev != null) {
            prev.next = node;
        }
        // 只有上一层第一次处理的时候，nextStart 为 null
        if (nextStart == null) {
            nextStart = node;
        }
        prev = node;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};