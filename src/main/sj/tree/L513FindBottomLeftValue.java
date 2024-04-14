package sj.tree;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class L513FindBottomLeftValue {
    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int res = -1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            res = queue.peekFirst().val;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }

        }

        return res;
    }

    /**
     * 递归法
     */
    private int res;
    private int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        recursion(root, 1);
        return res;
    }

    private void recursion(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }
        recusion(root.left, depth + 1);
        recusion(root.right, depth + 1);
    }
}
