package sj.tree;

import resources.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-2-24 下午7:49
 * shijia0620@126.com
 * write a function kthSmallest to find the kth smallest element in BST.
 */
public class L230kthSmallest {
    //TODO 中序遍历--循环
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) return node.val;
            node = node.right;
        }
        return node.val;
    }

    //   TODO DFS
    public int dfs(TreeNode root, int k) {
        int count = countNode(root.left);
        if (count >= k) {
            return dfs(root.left,k);
        } else if (count < k) {
            return dfs(root.right,k-count-1);
        }
        return root.val;
    }

    //    计数，count节点数
    public int countNode(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
