package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-3-23 下午9:07
 * shijia0620@126.com
 * tree 的镜像翻转
 */
public class N_MirrorTree {
    public void mirror(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        mirror(root.left);
        mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
