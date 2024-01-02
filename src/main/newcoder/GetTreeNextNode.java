package newcoder;

import common.TreeLinkNode;

/**
 * Created by steven on 18-3-29 下午9:39
 * shijia0620@126.com
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 */
public class GetTreeNextNode {
    public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {
        if(pNode == null ) return null;
        // 有右孩子
        if(pNode.right != null){
            return getLeftNode(pNode.right);
        }else if(pNode.next != null && pNode.next.left == pNode){//todo 是父亲的左孩子
            return pNode.next;
        }else{
            while(pNode.next != null && pNode.next.right == pNode){
                pNode = pNode.next;
            }
            return pNode;
        }
    }
    public TreeLinkNode getLeftNode(TreeLinkNode node){
        if(node == null) return null;
        TreeLinkNode left = getLeftNode(node.left);
        return (left == null)? node: left;
    }

    //todo 正确答案
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;
        // has right child
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
        while (pNode.next!=null){
            if(pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
