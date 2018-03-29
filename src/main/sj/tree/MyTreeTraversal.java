package sj.tree;

import resources.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by steven on 18-2-23 上午8:58
 * shijia0620@126.com
 */
public class MyTreeTraversal {
    //TODO 非递归实现先序遍历：用栈而不是队列
    public List<Integer> preorderTaversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    //TODO 非递归中序遍历树  left -> root -> right
    public List<Integer> inorderTaversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        //todo 不需要先对root节点压栈
        while (!stack.isEmpty() || node != null) {
            //TODO 对于当前的每一个node，都要优先考虑其left child，直到为空时，pop
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    //TODO 非递归后序遍历树 left-right - root 无耻的想法：root-right-left,然后倒着插入
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;
    }

    // 逆序层次遍历
    public List<List<Integer>> reverseLevelTraverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        MyTreeTraversal a = new MyTreeTraversal();
        TreeNode root = TreeNode.getBiTree();

    }


}
