package sj.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by steven on 18-2-9 下午11:21
 * shijia0620@126.com
 *
 Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 求每一层的平均值
 */
public class L637AverageOfLevels {
    //TODO java队列一般选用 linkedList，offer()添加元素，poll()出队列 ，该方法称BFS

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // TODO： 最好使用 !q.isEmpty()，队列里边有null，size不为0,
        while (queue.size()!=0){
            //TODO 直接用double而不是int
            double curSum = 0;
            int size = queue.size();
            for(int i=size;i>0;i--){
                TreeNode node = queue.poll();
                curSum += node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // TODO double 放在curSum前面而不是商值前面。。。。
            list.add(curSum/size);
        }
        return list;
    }
}
