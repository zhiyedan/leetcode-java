package sj.tree;

import common.TreeNode;

/**
 * Created by steven on 18-2-9 下午10:19
 * shijia0620@126.com
 */
public class L617MergeTrees {
    /*出错：原因，有的点已经为空，还要访问它的左右子节点，因此错误
    新建一棵树*/
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if(t1==null && t2 == null)
            return null;
        int val = (t1!=null?t1.val:0) + (t2!=null?t2.val:0);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees1(t1.left,t2.left);
        node.right = mergeTrees1(t1.right,t2.right);
        return node;
    }
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1==null && t2 == null)
            return null;
        if(t1!=null && t2!=null){
            int val = t1.val+t2.val;
            TreeNode node = new TreeNode(val);
            node.left = mergeTrees2(t1.left,t2.left);
            node.right = mergeTrees2(t1.right,t2.right);
            return node;
        }else if(t1 == null)
            return t2;
        else
            return t1;
    }
    //最佳答案：即第一版的修正。
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        if(t1==null && t2 == null) return null;
        int val = (t1!=null?t1.val:0) + (t2!=null?t2.val:0);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees3(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees3(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
    // 简洁版，相对于自己写的，把有空值的放在前面。
    public TreeNode mergeTrees4(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode n= new TreeNode(t1.val+t2.val);
        n.left=mergeTrees4(t1.left, t2.left);
        n.right=mergeTrees4(t1.right, t2.right);
        return n;
    }
    /* python版本
    def mergeTrees(self, t1, t2):
        if not t1 and not t2: return None
        ans = TreeNode((t1.val if t1 else 0) + (t2.val if t2 else 0))
        ans.left = self.mergeTrees(t1 and t1.left, t2 and t2.left)
        ans.right = self.mergeTrees(t1 and t1.right, t2 and t2.right)
        return ans
    其中：t1 and t1.left表示：t1.left if t1 is not None else None
     */
}
