package com.jemmy.algorithm.leetcode.dfs;

import com.jemmy.algorithm.leetcode.top.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/9/27
 */
public class LowestCommonAncestorOfABinarySearchTree_235 {

    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Clarification: 最近公共祖先，二叉搜索树
        // 方案1: 递归 - 自顶向下 两个节点分布可能：分别在左右子树，都在左子树，都在右子树
        // 递归参数: 当前节点、p、q
        // 递归返回值: 当前子树是否包含目标节点
        // 时间复杂度: O(n)
        // 空间复杂度: O(n)

        recursive(root, p, q);
        return res;
    }

    private boolean recursive(TreeNode node, TreeNode p, TreeNode q) {
        // terminator
        if (node == null) {
            return false;
        }

        // process current logic
        // drill down
        boolean lSon = recursive(node.left, p, q);
        boolean rSon = recursive(node.right, p, q);

        // 最近公共祖先: 左右子树包含 p 和 q 、或者当前节点为 p 或 q，
        boolean isAncestor = (lSon && rSon) || ((node.val == p.val || node.val == q.val) && (lSon || rSon));
        if (isAncestor) {
            res = node;
        }

        // reverse current states

        return lSon || rSon || node.val == p.val || node.val == q.val;
    }

    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private Set<Integer> parentSet  = new HashSet<>();

    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        // 方案2: 递归 - 自底向上
        // 使用 Map 记录每个节点的父节点，然后 p 一直往上，记录经过的父节点，q 一直往上，判断每个父节点也是 p 的父节点

        // 遍历所有节点，记录每个节点的父节点
        dfs(root);

        // 从p节点往上找父节点，并记录
        while (p != null) {
            // 当前节点可能就是公共祖先
            parentSet.add(p.val);
            p = parentMap.get(p.val);
        }

        // 从q节点往上找父节点，判断是否在p的父节点集合中
        while (q != null) {
            // 当前节点可能就是公共祖先
            if (parentSet.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }

        return null;
    }

    private void dfs(TreeNode node) {
        // terminator
        if (node == null) {
            return;
        }

        // process current logic
        // drill down
        // 需要下探一层，建立当前节点和父节点关联
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            dfs(node.left);
        }

        if (node.right != null) {
            parentMap.put(node.right.val, node);
            dfs(node.right);
        }

        // reverse current states
    }
}
