package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-2-23 下午6:47
 * shijia0620@126.com
 *
 * 右先序和中序遍历产生二叉树
 */
public class L105BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helpFun(0,0,preorder.length-1,preorder,inorder);
    }
    private TreeNode helpFun(int preStart,int inStart, int inEnd, int[] preorder , int[] inorder){
        if(preStart>= preorder.length || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == preorder[preStart]) inIndex=i;
        }
        node.left = helpFun(preStart+1,inStart,inIndex-1,preorder,inorder);
        node.right = helpFun(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        return node;
    }
}
