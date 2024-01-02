package sj.linkedList;

import common.ListNode;

/**
 * Created by steven on 18-3-29 下午8:24
 * shijia0620@126.com
 *
 * 如果链表有环路，找到其环路入口
 */
public class L142_CycleEntrance {
    //todo 快慢指针先相遇，一个指针回到原点，再以相同速度行走。
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = hasCycle(head);
        if (meetNode == null) return null;
        while (head != meetNode) {
            head = head.next;
            meetNode = meetNode.next;
        }
        return head;
    }

    public ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }
}
