package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-13 下午7:38
 * shijia0620@126.com
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 很简单，不需要记录。
 */
public class L112HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
