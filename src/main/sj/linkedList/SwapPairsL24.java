package sj.linkedList;

import common.ListNode;
/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairsL24 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode otherNode = swapPairs(head.next.next);

        ListNode next = head.next;
        head.next = otherNode;
        next.next = head;

        return next;
    }

    /**
     * 抄答案做出来的，一定要画出顺序来，多加临时变量，然后按顺序链接。
     * @param head
     * @return
     */
    public ListNode normal(ListNode head) {

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        ListNode first;
        ListNode second;
        ListNode third;

        while (cur.next != null && cur.next.next != null) {

            first = cur.next;
            second = first.next;
            third = second.next;

            cur.next = second;
            second.next = first;
            first.next = third;

            cur = first;

        }
        return newHead.next;
    }
}
