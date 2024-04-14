package sj.tree;

import java.util.*;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class L538CumSumBST {

    public TreeNode convertBST(TreeNode root) {

        int curSum = 0;
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            curSum += cur.val;
            cur.val = curSum;

            cur = cur.left;

        }

        return root;

    }
}
