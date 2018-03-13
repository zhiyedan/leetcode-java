package sj.tree;

import resources.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-2-24 下午4:39
 * shijia0620@126.com
 * <p>
 * Given an integer n, generate all structurally unique BST's
 */
public class L95GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        // TODO 应该return new ArrayList<>() 而不是null;
        if (n == 0) return null;
        return helpFun(1, n);
    }

    List<TreeNode> helpFun(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end){
            //TODO 这里必须是 add null
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = helpFun(start,i-1);
            List<TreeNode> rights = helpFun(i+1,end);
            for(TreeNode left : lefts){
                for(TreeNode right: rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
