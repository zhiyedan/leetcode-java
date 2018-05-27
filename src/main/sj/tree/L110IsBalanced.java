package sj.tree;

import resources.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by steven on 18-2-21 上午9:22
 * shijia0620@126.com
 *
 * 判断是否为平衡树，左右子树depth差不能大于1
 */
public class L110IsBalanced {
   // 先求深度 从上往下 复杂度：O(N*logN)
    public boolean isBalanced1(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
        return isBalanced1(root.left) && isBalanced1(root.right);
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    // TODO 网上复杂度为O(N)的算法 自下而上
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        return dfsHeight2(root) != -1;
    }
    // TODO 可以优化，如果left== -1 直接返回，不用算right
    private int dfsHeight1(TreeNode root){
        if(root == null) return 0;
        int left = dfsHeight1(root.left);
        int right = dfsHeight1(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
    private int dfsHeight2(TreeNode root){
        if(root == null) return 0;
        int left = dfsHeight2(root.left);
        if(left == -1) return -1;
        int right = dfsHeight2(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }

}
