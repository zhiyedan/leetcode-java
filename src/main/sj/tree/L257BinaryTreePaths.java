package sj.tree;

import resources.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-2-13 上午9:31
 * shijia0620@126.com
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 */
public class L257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if(root != null)
            helpFun(root,"",list);
        return list;
    }
    // TODO 这里的结束条件是叶子节点而不是null节点
    public void helpFun(TreeNode root, String path, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        if (root.left != null) {
            helpFun(root.left, path + root.val + "->", list);
        }
        if (root.right != null) {
            helpFun(root.right, path + root.val + "->", list);
        }
    }
}
