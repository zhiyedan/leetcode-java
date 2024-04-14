package sj.tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-2-24 下午6:39
 * shijia0620@126.com
 * 判断是否为有效的二叉搜索树
 * determine if it is a valid binary search tree (BST).
 */
public class L98IsValidBST {

    /**
     * 迭代法，DFS，中序遍历，注意最大值要使用double类型，否则有溢出。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre;

        while(!stack.isEmpty() || root != null){
            // 左
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // 中
            root = stack.pop();
            if(pre != null && root.val <= pre){
                return false;
            }
            pre = root;

            // 右
            root = root.right;
        }

        return true;
    }

    /**
     * 递归法
     */
    TreeNode max;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }


}
