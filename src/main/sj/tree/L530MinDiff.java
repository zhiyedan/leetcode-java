package sj.tree;

import java.util.*;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class L530MinDiff {

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public int getMinimumDifferenceDFS(TreeNode root) {

        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            // 循环左
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 中--主要执行逻辑，记得要对pre进行更新
            root = stack.pop();
            if (pre != null) {
                int diff = Math.abs(root.val - pre.val);
                result = Math.min(result, diff);
            }
            pre = root;

            // 右
            root = root.right;
        }

        return result;

    }


    /**
     * 递归法
     */
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifferenceRecursion(TreeNode root) {
        recursion(root);
        return result;
    }

    void recursion(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            recursion(node.left);
        }

        if (pre != null) {
            int diff = Math.abs(node.val - pre.val);
            result = Math.min(result, diff);
        }
        pre = node;

        if (node.right != null) {
            recursion(node.right);
        }

    }
}
