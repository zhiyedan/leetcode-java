package sj.linkedList;

import common.ListNode;
public class ReverseListL206 {
    public ListNode reverseList1(ListNode head) {

        if (head == null) return null;

        ListNode newHead = new ListNode();

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = newHead.next;
            newHead.next = cur;

            cur = next;
        }
        // 记住是next不是newHead
        return newHead.next;
    }


    /**
     * 简化版
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 递归版本
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode nextHead = reverseList3(head.next);
        // TODO 这一层挺难的，之前愚蠢的做法是遍历到最后一个元素，
        //  想一想，最后一个元素不就是你当前节点的next么？
        head.next.next = head;
        head.next = null;

        return nextHead;
    }
}
