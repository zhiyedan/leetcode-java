package sj.tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class L236CommonAncestor {

    /**
     * TODO 难点在于树的建立是自上而下的，但本题目是自下而上的遍历顺序。
     * 应该是后续遍历，遇到目标值就返回。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归终止条件
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右都为空直接返回
        if (left == null && right == null) {
            return null;
        }

        // 左右都不为空
        if (left != null && right != null) {
            return root;
        }

        // p或者q上传
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右都为空且自身不是目标值直接返回
        if (left == null && right == null && root != q && root != p) {
            return null;
        }

        // 已经找到结果了
        if (left != null && left != q && left != p) {
            return left;
        }
        if (right != null && right != q && right != p) {
            return right;
        }

        // 自身是祖先或者自身是pq
        if ((left == q || left == p) && (right == p || right == q) ||
                (root == p || root == q)) {
            return root;
        }

        // p或者q上传
        return left == null ? right : left;

    }
}
