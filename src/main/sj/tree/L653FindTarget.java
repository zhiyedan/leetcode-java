package sj.tree;

import common.TreeNode;

import java.util.*;

/**
 * Created by steven on 18-2-13 下午3:56
 * shijia0620@126.com
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * 二叉搜索树，找到两个节点之和为target
 */
public class L653FindTarget {

    //TODO 要是两数之和的题，一定要记得用哈希表来做
    public boolean findTarget1(TreeNode root, int k) {
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();
        return helpFunction(root,k,set);
    }
    public boolean helpFunction(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return helpFunction(root.right,k,set) || helpFunction(root.left,k,set);
    }

    // TODO BFS 加 hashset
    public boolean findTarget(TreeNode root, int k){
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(set.contains(k-node.val)) return true;
            set.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return false;
    }

    // 给定一个递增序列的list，求两个元素的sum为target
    public boolean twoSum(List<Integer> list, int target){
        if(list == null) return false;
        int i=0,j=list.size()-1;
        while (i<j){
            int curSum = list.indexOf(i) + list.indexOf(j);
            if(curSum == target) return true;
            if(curSum > target) j--;
            if(curSum < target) i++;
        }
        return false;
    }
}
