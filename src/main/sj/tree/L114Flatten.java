package sj.tree;

import resources.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-23 下午2:38
 * shijia0620@126.com
 *
 * 将树拍扁，成为链表形状，
 */
public class L114Flatten {

    private Queue<TreeNode> queue;
    public void flatten(TreeNode root) {
        queue = new LinkedList<>();
        if(root == null) return;
        myDfs(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            node.left = null;
            node.right = queue.peek();
        }
    }
    private void myDfs(TreeNode root){
        if(root == null) return;
        queue.offer(root);
        myDfs(root.left);
        myDfs(root.right);
    }

    // 网上最优解：递归
    private TreeNode recursive(TreeNode root, TreeNode lastNode){
        if(root == null) return lastNode;
        root.right = recursive(root.left,recursive(root.right,lastNode));
        root.left = null;
        return root;
    }
}
