package sj.linkedList;

import common.TreeNode;

/**
 * Created by steven on 18-3-24 上午11:24
 * shijia0620@126.com
 * 树转双向链表
 */
public class N_ConvertTree2List {
    TreeNode treeHead = null;
    TreeNode preHead = null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        recursive(pRootOfTree);
        return treeHead;
    }
    public void recursive(TreeNode root) {
        if (root == null) return;
        recursive(root.left);
        if(treeHead==null){
            treeHead = root;
        }else {
            preHead.right = root;
            root.left = preHead;
        }
        preHead = root;
        recursive(root.right);
    }

    // todo 二叉搜索树，中序遍历，上一个遍历的node就是当前node的了法庭，左子树的head就是当前node的head
    // lastNode 用额外的空间保存， head直接函数返回。
    TreeNode lastNode = null;
    public TreeNode Convert(TreeNode node){
        if(node == null) return null;
        if(node.left == null && node.right == null) {
            lastNode = node;
            return node;
        }
        TreeNode leftHead = Convert(node.left);

        if(leftHead != null){
            lastNode.right = node;
            node.left = lastNode;
        }

        lastNode = node;

        TreeNode right = Convert(node.right);
        if(right != null){
            node.right = right;
            right.left = node;
        }

        return leftHead==null?node:leftHead;
    }
}
