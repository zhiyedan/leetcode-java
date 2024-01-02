package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-13 下午7:43
 * shijia0620@126.com
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 */
public class L543DiameterOfBinaryTree {

    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helpFun(root);
        return max;
    }
    public int helpFun(TreeNode root){
        if(root == null) return 0;
        //TODO 这一行可以去掉
        if(root.left == null && root.right == null) return 1;
        int leftPath = helpFun(root.left);
        int rightPath = helpFun(root.right);
        max = Math.max(max,leftPath+rightPath);
        return Math.max(leftPath,rightPath)+1;
    }

}
