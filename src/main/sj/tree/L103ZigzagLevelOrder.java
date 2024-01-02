package sj.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by steven on 18-2-23 下午12:53
 * shijia0620@126.com
 * <p>
 * 之字型打印每层
 */
public class L103ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        int flag = -1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //TODO 这一步变通,TreeNode在queue中的位置不变，而是输出改变。
                if (flag == -1) list.add(node.val);
                else list.add(0, node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            flag *= -1;
            result.add(list);
        }
        return result;
    }

    // DFS
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (level == result.size()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        List<Integer> list = result.get(level);
        if (level % 2 == 0) list.add(root.val);
        else list.add(0, root.val);
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}
