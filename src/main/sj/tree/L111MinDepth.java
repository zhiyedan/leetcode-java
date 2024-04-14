package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-9 下午10:40
 * shijia0620@126.com
 */
/*
* Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* */
public class L111MinDepth {
    // 看似简单，但确实做错了。。。。 比如它只有一个左节点，则最小值为2......
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    // 最佳答案
    public int solution(TreeNode root) {
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
    /*
    class Solution(object):
        def minDepth(self, root):
            if not root: return 0
            if root.left and root.right:
                return min(self.minDepth(root.left), self.minDepth(root.right))+1
            else:
                return self.minDepth(root.left) + self.minDepth(root.right) + 1
    * */
}
