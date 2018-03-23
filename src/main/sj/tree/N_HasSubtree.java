package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-3-23 下午8:33
 * shijia0620@126.com
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 */
public class N_HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null) return false;
        if(isSame(root1,root2)) return true;
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
