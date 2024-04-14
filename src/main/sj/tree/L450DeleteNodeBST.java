package sj.tree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class L450DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        if (root.val == key) {
            // 需要变动和不需要变动
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode cur = root.right;
            // TODO 找到最左侧的叶子节点 这里不是 cur!=null ！！！
            while (cur.left != null) {
                cur = cur.left;
            }
            // 左孩子接到右子树的最小值位置
            cur.left = root.left;
            return root.right;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }
}
