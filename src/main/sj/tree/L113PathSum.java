package sj.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by steven on 18-2-13 上午9:47
 * shijia0620@126.com
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 找到所有的从root到叶子节点和为target的路径
 */
public class L113PathSum {

    // 网上最优解：
    // TODO 优化点：没必要没增加一个valnew一个list，可以用stack，开始的时候进栈，结束时退栈, targetSum = sum - val即可
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        help2(root, sum, stack, result);
        return result;
    }

    public void help2(TreeNode root, int sum, Stack<Integer> stack, List<List<Integer>> result) {

        if (root == null) return;

        stack.push(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(stack));
        }
        if (root.left != null) {
            help2(root.left, sum - root.val, stack, result);
        }
        if (root.right != null) {
            help2(root.right, sum - root.val, stack, result);
        }
        // TODO 压栈弹栈是关键！！！
        stack.pop();
    }

    /**
     * python
     * class Solution:
     *     def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
     *         if not root:
     *             return []
     *         stack = [(root, [root.val])]
     *         res = []
     *         while stack:
     *             node, path = stack.pop()
     *             if not node.left and not node.right and sum(path) == targetSum:
     *                 res.append(path)
     *             if node.right:
     *                 stack.append((node.right, path + [node.right.val]))
     *             if node.left:
     *                 stack.append((node.left, path + [node.left.val]))
     *         return res
     */
}
