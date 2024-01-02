package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-8 下午11:03
 * shijia0620@126.com
 */
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class L108SortedArrayToBST {
    public TreeNode solution(int[] nums) {
        return recurcive(nums,0,nums.length-1);
    }

    public TreeNode recurcive(int[] nums,int begin,int end){
        if(end<begin)
            return null;
        int mid = (begin + end)>>1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recurcive(nums,begin,mid-1);
        node.right = recurcive(nums,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
        L108SortedArrayToBST sj = new L108SortedArrayToBST();
        sj.solution(new int[]{-10,-3,0,5,9});
    }
}
