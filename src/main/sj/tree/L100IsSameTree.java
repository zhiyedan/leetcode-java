package sj.tree;

import resources.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-2-13 下午3:52
 * shijia0620@126.com
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 */
public class L100IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    //TODO 使用非递归的方法,利用stack or queue
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (! stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
        }
        return true;
    }
}
