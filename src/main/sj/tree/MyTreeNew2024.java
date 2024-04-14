package sj.tree;

import common.TreeNode;

import java.util.*;

/**
 * 时间复杂度都是o(n)，空间复杂度都是n(depth)，n=2*depth-1；
 */
public class MyTreeNew2024 {

    /**
     * 二叉树的层遍历--迭代法
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> layerOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(curLayer);
        }

        return res;

    }

    /**
     * 二叉树的层遍历--递归法
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> layerOrderCur(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        recursion(res, root, 1);

        return res;

    }

    private static void recursion(List<List<Integer>> res, TreeNode root, int depth) {

        if (root == null) return;
        // TODO 初始化层,如何判断当前层是否存在？
        if (res.size() < depth) {
            List<Integer> curLayer = new ArrayList<>();
            res.add(curLayer);
        }
        res.get(depth - 1).add(root.val);

        recursion(res, root.left, depth + 1);
        recursion(res, root.right, depth + 1);
    }


    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> perorder(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return res;
    }

    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorder1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                //TODO 在此添加
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return res;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> midorder(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //TODO 在此添加
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> midorder(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                stack.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            }
        }

        return res;
    }


}
