package sj.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-13 下午1:29
 * shijia0620@126.com
 * <p>
 * nvert a binary tree.
 */
public class L226InvertTree {

    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public TreeNode bfsInvertTree(TreeNode root) {

        if (root == null) return root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();

                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return root;
    }

    /**
     * dfs 迭代法 先序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return root;
    }
}
