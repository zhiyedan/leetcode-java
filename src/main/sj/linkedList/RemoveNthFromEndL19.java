package sj.linkedList;

import common.ListNode;

public class RemoveNthFromEndL19 {

    /**
     * 快慢指针：快的先走n步，然后一起走到头
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndQuickSlowPointer(ListNode head, int n) {

        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode fast = newHead;
        ListNode slow = newHead;

        // TODO 注意，这里要走n+1步，而非n；
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return newHead.next;


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;

        int size = nthFromEnd(head);
        for (int i = 0; i < size - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return newHead.next;
    }

    private int nthFromEnd(ListNode head) {
        if (head == null) return 0;
        return 1 + nthFromEnd(head.next);
    }
}
