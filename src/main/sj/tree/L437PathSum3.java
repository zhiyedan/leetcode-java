package sj.tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by steven on 18-2-16 下午5:36
 * shijia0620@126.com
 *
 * Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * 路径不需要从root到叶子节点，只需要从parent node 到 child node 即可。
 */
public class L437PathSum3 {

    //TODO 难点：怎么设置起点？起点应该可能是每一个node  双重递归！！！
    public int pathSum1(TreeNode root, int sum) {
        if(root == null) return 0;
        return helpFun(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    // 以给定的node为root，往下找所有可能的路径。
    public int helpFun(TreeNode root,int sum){
        if(root == null) return 0;
        return (root.val==sum)?1:0 + helpFun(root.left,sum-root.val) + helpFun(root.right,sum-root.val);
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map);
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        //See if there is a subarray sum equals to target
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }
}
