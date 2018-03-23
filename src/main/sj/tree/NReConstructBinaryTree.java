package main.sj.tree;
import resources.TreeNode;

// todo 根据先序遍历和中序遍历构建二叉树
public class NReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int preL=0,inL=0;
        int preR=pre.length-1, inR=in.length-1;
        return build(pre,preL,preR,in,inL,inR);
    }
    private TreeNode build(int [] pre,int preL,int preR,int [] in,int inL,int inR){
        if(preL>preR || inL > inR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = findIndex(pre[preL],in,inL,inR);
        root.left = build(pre,preL+1,preL+(inIndex-inL),in,inL,inIndex-1);
        root.right = build(pre,preL+(inIndex-inL)+1,preR,in,inIndex+1,inR);
        return root;
    }
    private int findIndex(int target,int[] array,int l, int r){
        for(int i= l; i<=r; i++){
            if(target == array[i])
                return i;
        }
        return -1;
    }
}
