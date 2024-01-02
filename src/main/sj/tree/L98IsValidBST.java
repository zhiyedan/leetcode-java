package sj.tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-2-24 下午6:39
 * shijia0620@126.com
 *
 * determine if it is a valid binary search tree (BST).
 */
public class L98IsValidBST {

//  错误。。。
    public boolean isValidBST(TreeNode root) {
        if(root == null || root.left==null && root.right == null) return true;

        return helpFun(root.left,root.val,true) && helpFun(root.right,root.val,false);

    }
    // TODO 这种做法是错误的，约束条件只传三代本身不合理。
    public boolean helpFun(TreeNode root, int baseValue, boolean isLeftSon){
        if(root == null || root.left==null && root.right == null) return true;

        if(root.left != null ){
            if(root.left.val >= root.val || !isLeftSon && root.left.val<=baseValue) return false;
        }
        if(root.right != null){
            if(root.right.val <= root.val || isLeftSon && root.right.val >= baseValue) return false;
        }

        return helpFun(root.left,root.val,true) && helpFun(root.right,root.val,false);
    }

//    TODO dfs
    public boolean isValidBST2(TreeNode root){
//        TODO 这里不能使用Integer，而应该是long 或者对象null
//        return help2(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return help2(root,null,null);

    }

    private boolean help2(TreeNode root, Integer minValue, Integer maxValue) {
        if(root == null) return true;
        if(minValue != null && root.val <= minValue || maxValue != null && root.val >= maxValue) return false;
        return help2(root.left,minValue,root.val) && help2(root.right,root.val,maxValue);
    }
    //TODO 利用中序遍历，从小到大，每次弹出来的数一定大于前一个数字，否则返回false
    public boolean isValidBST3(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
//        TODO ERROR！！！root被压栈两次。。。。。
        stack.push(root);
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(pre != null && node.val <= pre.val) return false;
            pre = node;
            node = node.right;
        }
        return true;
    }
}
