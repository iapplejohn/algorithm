package com.jemmy.algorithm.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 面试题68 - II. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/7/17
 */
public class ErChaShuDeZuiJinGongGongZuXianLcof {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Clarification: 公共的父节点，该节点可能是其中一个节点
        // 方案1: 递归，自顶向下，判断左子树和右子树是否都包含指定节点，在递归中聚合左右子树的结果

        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        // terminator
        if (node == null) {
            return false;
        }

        // process current
        boolean curMatched = false;
        if (node.val == p.val || node.val == q.val) {
            // 这里不能返回，否则，后续查找左右子树的操作不会执行，该节点为公共祖先的场景就不能涵盖到
            curMatched = true;
        }

        // drill down
        boolean lSon = false, rSon = false;
        if (node.left != null) {
            lSon = dfs(node.left, p, q);
        }
        if (node.right != null) {
            rSon = dfs(node.right, p, q);
        }

        if (lSon && rSon || ((lSon || rSon) && curMatched)) {
            ans = node;
        }

        // reverse current
        return lSon || rSon || curMatched;
    }

    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        // 方案2: 自底向上 + map辅助
        // 先遍历各个节点，获取对应的父节点，然后从p和q向上找公共祖先

        TreeNode res = null;

        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        recursive(root, parentMap);

        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                res = q;
                break;
            }
            q = parentMap.get(q.val);
        }

        return res;
    }

    private void recursive(TreeNode node, Map<Integer, TreeNode> parentMap) {
        // terminator
        if (node == null) {
            return;
        }

        if (node.left != null) {
            // process current
            parentMap.put(node.left.val, node);

            // drill down
            recursive(node.left, parentMap);
        }
        if (node.right != null) {
            // process current
            parentMap.put(node.right.val, node);

            // drill down
            recursive(node.right, parentMap);
        }

        // reverse current
    }

}
