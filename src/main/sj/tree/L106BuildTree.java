package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-2-23 下午7:06
 * shijia0620@126.com
 *
 * 根据中序和后序构建tree
 */
public class L106BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helpFun(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    TreeNode helpFun(int postEnd,int inStart, int inEnd, int[] inorder, int[] postorder){
        if(postEnd<0 || inStart>inEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        //在inorder中找到划分点
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == postorder[postEnd]){
                inIndex = i;
                break;
            }
        }
        node.right = helpFun(postEnd-1,inStart,inIndex-1,inorder,postorder);
        node.left = helpFun(postEnd-(inorder.length-inIndex)-1,inIndex+1,inEnd,inorder,postorder);
        return node;
    }
}
