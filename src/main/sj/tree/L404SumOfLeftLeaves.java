package sj.tree;

import resources.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-16 下午5:07
 * shijia0620@126.com
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 */
public class L404SumOfLeftLeaves {

    private int sum;
    public int sumOfLeftLeaves1(TreeNode root) {
        sum = 0;
        helpFun(root);
        return sum;
    }
    public void helpFun(TreeNode root){
        if(root == null) return ;
        if(root.left != null && root.left.left==null && root.left.right == null) sum+= root.left.val;
        helpFun(root.left);
        helpFun(root.right);
    }
    //TODO 只用一个函数去实现,简洁版
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.left.left==null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves2(root.right);
        return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }
    //TODO  BFS
    public int sumOfLeftLeaves3(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null && node.left.left==null && node.left.right == null)
                sum += node.left.val;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return sum;
    }
}
