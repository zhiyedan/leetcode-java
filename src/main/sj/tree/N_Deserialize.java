package sj.tree;

import resources.TreeNode;

import java.util.Stack;

/**
 * Created by steven on 18-3-30 上午12:04
 * shijia0620@126.com
 *
 * 二叉树的序列化与反序列化
 */
public class N_Deserialize {
    public String serialize(TreeNode root){
        if(root == null) return "";
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) sb.append("#,");
            else {
                sb.append(node.val).append(",");
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    int index = 0;
    public TreeNode deserialize(String str){
        index=-1;
        String[] strings = str.split(",");
        if(str == null || str.length()==0) return null;
        return recursive(strings);
    }

    private TreeNode recursive(String[] strings) {
        index++;
        if(index>strings.length) return null;
        String val = strings[index];
        if(val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = recursive(strings);
        node.right = recursive(strings);
        return node;
    }

    public static void main(String[] args) {
        N_Deserialize a = new N_Deserialize();
        TreeNode root = a.deserialize("5,4,11,7,#,#,2,#,#,#,8,13,#,#,4,5,#,#,1,#,#,");
        System.out.println(a.serialize(root).equals("5,4,11,7,#,#,2,#,#,#,8,13,#,#,4,5,#,#,1,#,#,"));
    }
}
