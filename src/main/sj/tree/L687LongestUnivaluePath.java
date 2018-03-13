package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-2-14 上午11:17
 * shijia0620@126.com
 * <p>
 * find the length of the longest path where each node in the path has the same value
 * 找一条最长的路径，路径中每个点val都相同
 */
public class L687LongestUnivaluePath {

    private int longPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        helpFun(root);
        return longPath;
    }

    // TODO 自下而上，判断时顺序想不明白
    public int helpFun(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        int leftPath = helpFun(root.left);
        int rightPath = helpFun(root.right);
        // 左右连起来
        if (root.left != null && root.right != null && root.val == root.left.val && root.left.val == root.right.val) {
            int curPath = rightPath + leftPath + 2;
            longPath = Math.max(longPath, curPath);
            return Math.max(leftPath,rightPath) + 1;
        }
        // 左边连起来
        if (root.left != null && root.val == root.left.val) {
            longPath = Math.max(longPath,leftPath+1);
            return leftPath + 1;
        }
        // 右边连起来
        if (root.right != null && root.val == root.right.val) {
            longPath = Math.max(longPath,rightPath+1);
            return rightPath + 1;
        }
        return 0;
    }

    // TODO 网上答案： 自上而下
    private int getLen(TreeNode node, int val){
        if(node == null) return 0;
        int left = getLen(node.left,node.val);
        int right = getLen(node.right,node.val);
        //TODO 神来之笔，why???
        longPath = Math.max(longPath,left+right);
        if(node.val == val)
            return Math.max(left,right) + 1;
        return 0;
    }
}
