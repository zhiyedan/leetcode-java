package sj.tree;

import common.ListNode;
import common.TreeNode;

/**
 * Created by steven on 18-2-24 下午9:53
 * shijia0620@126.com
 */
public class L109sortedListToBST {
    //TODO 思路和数组一样，先找到中点，然后找left，right，
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return recursive(head,null);
    }

    public TreeNode recursive(ListNode head, ListNode tail){

        // TODO 但是如何找中点，一个技巧是快慢指针！
        ListNode fast = head;
        ListNode slow = head;
        if(head == tail ) return null;

        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = recursive(head,slow);
        node.right = recursive(slow.next,tail);
        return node;
    }
}
