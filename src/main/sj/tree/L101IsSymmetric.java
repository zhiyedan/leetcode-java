package sj.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-13 下午9:38
 * shijia0620@126.com
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 */
public class L101IsSymmetric {
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return helpFun(root.left,root.right);
    }
    public boolean helpFun(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null) return true;
        //TODO 下面写法是有问题的，如果有一个node为空，则node.val就有error，所以还是要判断是否为空。
//        if(leftNode.val == rightNode.val){
        if(leftNode != null && rightNode !=null && leftNode.val == rightNode.val){
            return helpFun(leftNode.left,rightNode.right) && helpFun(leftNode.right,rightNode.left);
        }
        return false;
    }
    //TODO 也可以写成这样：非常简洁
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    //TODO 还可以用BFS
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            // TODO 应该是继续而不是return
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
