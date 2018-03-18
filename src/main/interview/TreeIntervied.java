package interview;

import resources.TreeNode;
import sj.tree.MyTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by steven on 18-3-16 下午7:49
 * shijia0620@126.com
 */
public class TreeIntervied {
    //逆序层次遍历
    public void solution(TreeNode root){
        List<List<String>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        List<String> list = new ArrayList<>();
        list.add("{"+root.val+"}");
        result.add(list);
        while (!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                StringBuilder sb = new StringBuilder("{");
                if(node.right != null){
                    queue.offer(node.right);
                    sb.append(node.right.val).append(" ");
                }
                if(node.left != null){
                    queue.offer(node.left);
                    sb.append(node.left.val);
                }
                sb.append("}");
                list.add(sb.toString());
            }
            result.add(0,list);
        }
        for(List<String> list1: result){
            for(String string: list1){
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeIntervied treeIntervied = new TreeIntervied();
        TreeNode  node = TreeNode.getBiTree();
        MyTreeTraversal myTreeTraversal = new MyTreeTraversal();
        List<List<Integer>> list = myTreeTraversal.reverseLevelTraverse(node);
        treeIntervied.show(list);
        treeIntervied.solution(node);
    }
    public void show(List<List<Integer>> result){
        for(List<Integer> list1 : result){
            for(int a : list1){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
