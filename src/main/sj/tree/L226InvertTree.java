package sj.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-13 下午1:29
 * shijia0620@126.com
 *
 * nvert a binary tree.
 */
public class L226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    //上面解法没有用到递归的返回值
//    TODO 本身来讲属于DFS
    public TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
//    TODO： BFS 做法
    public TreeNode bfsInvertTree(TreeNode root){
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
