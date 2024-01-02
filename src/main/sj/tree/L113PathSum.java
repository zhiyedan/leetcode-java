package sj.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by steven on 18-2-13 上午9:47
 * shijia0620@126.com
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 找到所有的从root到叶子节点和为target的路径
 */
public class L113PathSum {
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> formerList = new ArrayList<>();
        int formerSum = 0;
        if (root != null) helpFun(root,result, formerList, formerSum, sum);
        return result;
    }

    public void helpFun(TreeNode root,List<List<Integer>> result, List<Integer> formerList, int formerSum, int targetSum) {
        if(root.left == null && root.right == null){
            if(formerSum + root.val == targetSum){
                List<Integer> curList = new ArrayList<>(formerList);
                curList.add(root.val);
                result.add(curList);
            }
        }
        if(root.left != null){
            List<Integer> curList = new ArrayList<>(formerList);
            curList.add(root.val);
            helpFun(root.left,result,curList,formerSum+root.val,targetSum);
        }
        if(root.right != null){
            List<Integer> curList = new ArrayList<>(formerList);
            curList.add(root.val);
            helpFun(root.right,result,curList,formerSum+root.val,targetSum);
        }
    }

    public static void main(String[] args) {
        L113PathSum solution = new L113PathSum();
        TreeNode root = TreeNode.getBiTree();
        solution.pathSum1(root,22);
    }

    // 网上最优解：
    // TODO 优化点：没必要没增加一个valnew一个list，可以用stack，开始的时候进栈，结束时退栈, targetSum = sum - val即可
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        help2(root,sum,stack,result);
        return result;
    }
    public void help2(TreeNode root,int sum,Stack<Integer> stack,List<List<Integer>> result){
        if(root == null) return;
        stack.push(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            result.add(new ArrayList<>(stack));
        }
        if(root.left != null){
            help2(root.left,sum-root.val,stack,result);
        }
        if(root.right != null){
            help2(root.right,sum-root.val,stack,result);
        }
        stack.pop();
    }
}
