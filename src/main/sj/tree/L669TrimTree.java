package sj.tree;

import resources.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by steven on 18-2-8 下午11:15
 * shijia0620@126.com
 */
/*
二叉搜索树，给定(L,R)区间，去掉区间外的节点
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 */
public class L669TrimTree {
    public TreeNode solution(TreeNode root,int L, int R){
        if(root==null)
            return null;
        if(root.val>R)
            return solution(root.left,L,R);
        if(root.val<L)
            return solution(root.right,L,R);
        root.left = solution(root.left,L,R);
        root.right = solution(root.right,L,R);
        return root;
    }
}
