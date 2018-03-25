package sj.tree;

import resources.TreeNode;

import java.util.HashMap;

/**
 * Created by steven on 18-2-24 下午10:38
 * shijia0620@126.com
 * hard...  find the maximum path sum.可以是任意一条路径，
 */
public class L124maxPathSum {

    //TODO 想明白一点，肯定是某个节点的做路径加上右路径。
    int maxSum;
    public int maxPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        helpfun(root);
        return maxSum;
    }

    public int helpfun(TreeNode root) {
        if(root == null) return 0;

        //todo 为什么是0而不是node.val???
        int leftMaxSum = Math.max(0, helpfun(root.left));
        int rightMaxSum = Math.max(0, helpfun(root.right));
        //todo 生成路径
        maxSum = Math.max(maxSum,root.val + leftMaxSum + rightMaxSum);
        //todo 返回最长子路径
        return Math.max(leftMaxSum,rightMaxSum)+root.val;
    }
}
