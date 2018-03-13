package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-2-13 下午10:19
 * shijia0620@126.com
 *
 * construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()"
 */
public class L606Tree2Str {
    //TODO 不完全对
    public String helpFun(TreeNode root){
        if(root == null) return "";
        if(root.left == null && root.right == null) return "(" + root.val + ")";
        if(root.left != null && root.right != null) return "" + root.val + helpFun(root.left) + helpFun(root.right);
        if(root.left == null) return "(" + root.val + "()" + helpFun(root.right) + ")";
        return "(" + root.val + helpFun(root.left) + helpFun(root.right) + ")";
    }

    public String tree2str(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) return "" + t.val;
        if(t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
