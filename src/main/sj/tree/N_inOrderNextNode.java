package sj.tree;

import common.TreeLinkNode;

/**
 * Created by steven on 18-3-30 上午12:56
 * shijia0620@126.com
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 */
public class N_inOrderNextNode {
    //todo 有右孩子找最左边的孩子，没有的话找左爹
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        // has right child
        if (pNode.right != null) {
            pNode = pNode.right;
            //todo 这里的判断条件是node.left不为空
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
