package sj.linkedList;

import common.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveElementsL203 {
    public ListNode removeElementsOrigin(ListNode head, int val) {

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode curNode = newHead;

        while (curNode.next != null) {
            // TODO 之前写错的原因是，不管删除还是不删除，curNode都跳转到了下一个节点，
            //  这样导致重复的数据只删除了第奇数个值，删除操作curNode不应该移动的。
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }

        return newHead.next;
    }

    /**
     * 递归的方式
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRecursion(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}
