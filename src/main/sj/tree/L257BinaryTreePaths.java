package sj.tree;

import common.TreeNode;

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


    public List<String> binaryTreePaths2(TreeNode root) {

        List<String> res = new ArrayList<>();
        Deque<TreeNode> nodeList = new LinkedList<>();

        fun(root,res, nodeList);

        return res;
    }

    private void fun(TreeNode root, List<String> res, Deque<TreeNode> nodeList){

        if(root == null) return;

        nodeList.offer(root);

        if(root.left == null && root.right == null){
            //TODO 这里用到了java8流式编程
            String path = nodeList.stream().map(node -> String.valueOf(node.val)).collect(Collectors.joining("->"));
            res.add(path);

        }else{
            fun(root.left, res, nodeList);
            fun(root.right, res, nodeList);
        }

        nodeList.remove(root);

    }

    /**
     * python 版本
     * class Solution:
     *     def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
     *         if not root:
     *             return []
     *         result = []
     *         self.traversal(root, [], result)
     *         return result
     *
     * def fun(self, res:List[str], node:TreeNode, path:List[int]) -> None:
     *  if not node:
     *      return
     *
     *  path.append(node.val)
     *
     *  if not node.left and not node.right:
     *      res.append('->'.join(map(str,path)))
     *  if node.left:
     *      self.fun(res, node.left, path)
     *  if node.right:
     *      self.fun(res, node.right, path)
     *
     *  path.pop()
     */
}
