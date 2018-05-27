package sj.tree;

import resources.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-3-30 上午12:31
 * shijia0620@126.com
 * <p>
 * <p>
 * 给定一颗二叉搜索树，请找出其中的第k大的结点
 */
public class N_KthNodeOfBST {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (!stack.isEmpty() || pRoot != null) {
            if(pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.right;
            }else {
                pRoot = stack.pop();
                index++;
                if(index == k) return pRoot;
                pRoot = pRoot.left;
            }
        }
        return null;
    }
}
