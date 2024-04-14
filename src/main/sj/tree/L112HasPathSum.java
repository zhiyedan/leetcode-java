package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-13 下午7:38
 * shijia0620@126.com
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 很简单，不需要记录。
 */
public class L112HasPathSum {
    //TODO true怎么层层往上传？通过或的形式！！！
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 迭代法，手动写stack
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumDFS(TreeNode root, int sum) {

        if (root == null) return false;

        //TODO 需要存储当前节点 and 从根节点到当前节点的和
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueNum = new LinkedList<>();
        queueNode.offer(root);
        queueNum.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode curNode = queueNode.poll();
            int num = queueNum.poll();
            if (curNode.left == null && curNode.right == null && num == targetSum) {
                return true;
            }
            if (curNode.left != null) {
                queueNode.offer(curNode.left);
                // TODO 切记，这里加的是子节点的val
                queueNum.offer(num + curNode.left.val);
            }
            if (curNode.right != null) {
                queueNode.offer(curNode.right);
                queueNum.offer(num + curNode.right.val);
            }
        }

        return false;

    }

    /**
     * 迭代法python写好简洁
     * class Solution:
     *     def hasPathSum(self, root: TreeNode, sum: int) -> bool:
     *         if not root:
     *             return False
     *         # 此时栈里要放的是pair<节点指针，路径数值>
     *         st = [(root, root.val)]
     *         while st:
     *             node, path_sum = st.pop()
     *
     *             if not node.left and not node.right and path_sum == sum:
     *                 return True
     *
     *             if node.right:
     *                 st.append((node.right, path_sum + node.right.val))
     *             if node.left:
     *                 st.append((node.left, path_sum + node.left.val))
     *         return False
     */

}
