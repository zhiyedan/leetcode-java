package sj.tree;

import common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by steven on 18-2-21 下午3:09
 * shijia0620@126.com
 * <p>
 * 新增next结点，指向其右侧节点。
 */
public class L116Connect {

    public void connectBFS(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeLinkNode node = queue.poll();
                if (i != len - 1) node.next = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    public void connectDFS(TreeLinkNode root) {
        if (root == null) return;
        helpFun(root, null);
    }

    public void helpFun(TreeLinkNode root, TreeLinkNode neighbor) {
        if (root == null) return;
        root.next = neighbor;
        helpFun(root.left, root.right);
        if (neighbor != null)
            helpFun(root.right, neighbor.left);
//       TODO 如果省略else会错误，香香为什么？
        else
            helpFun(root.right,null);
    }
}
